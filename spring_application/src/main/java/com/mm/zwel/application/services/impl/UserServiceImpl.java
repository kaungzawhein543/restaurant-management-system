/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.mm.zwel.application.services.impl;

import com.mm.zwel.application.constants.UserRole;
import com.mm.zwel.application.data_transfer_objects.RegisterDto;
import com.mm.zwel.application.data_transfer_objects.UserDto;
import com.mm.zwel.application.entities.User;
import com.mm.zwel.application.repositories.UserRepository;
import com.mm.zwel.application.services.UserService;
import com.mm.zwel.application.utilities.CommonUtility;
import com.mm.zwel.application.utilities.object_mapper.ObjectMapper;
import com.sun.jdi.request.DuplicateRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Example;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.List;

/**
 * UserServiceImpl Class.
 * <p>
 * </p>
 *
 * @author Zwel Naing Oo
 */

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findOne(Example.of(User.builder().username(username).build()))
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }

    @Override
    public UserDto getUserByUsername(String username) {
        return ObjectMapper.map(userRepository.findOne(Example.of(User.builder().username(username).build())).orElseThrow(() -> new UsernameNotFoundException("User not found: " + username)), UserDto.class);
    }


    @Override
    public UserDto save(UserDto userDto) {
        try {
            return ObjectMapper.map(userRepository.save(ObjectMapper.map(userDto, User.class)), UserDto.class);
        } catch (DataIntegrityViolationException e) {
            return extracted(e, userDto.getUsername(), userDto.getEmail());
        }
    }

    @Override
    public UserDto save(RegisterDto registerDto) {
        User user = ObjectMapper.map(registerDto, User.class);
        user.setRole(UserRole.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        try {
            return ObjectMapper.map(userRepository.save(user), UserDto.class);
        } catch (DataIntegrityViolationException e) {
            return extracted(e, registerDto.getUsername(), registerDto.getEmail());
        }
    }

    private UserDto extracted(DataIntegrityViolationException e, String userDto, String userDto1) {
        Throwable cause = e.getMostSpecificCause();
        if (cause instanceof SQLException) {
            String msg = cause.getMessage();
            if (msg.contains(User.ukUserUsername)) {
                throw new DuplicateRequestException("Duplicated username - " + userDto);
            }
            if (msg.contains(User.ukUserEmail)) {
                throw new DuplicateRequestException("Duplicated email - " + userDto1);
            }
        }
        cause.printStackTrace();
        throw CommonUtility.UNEXPECTED_RUNTIME_EXCEPTION;
    }

    @Override
    public Boolean existUsername(String username) {
        return userRepository.exists(Example.of(User.builder().username(username).build()));
    }

    @Override
    public String getCurrentUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();

            if (principal instanceof UserDetails userDetails) {
                return userDetails.getUsername();
            } else {
                return principal.toString();
            }
        }

        return null;
    }

    @Override
    public List<UserRole> getCurrentUserRoles() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            return authentication.getAuthorities().stream()
                    .map(e -> UserRole.valueOf(e.getAuthority().replace("ROLE_", "")))
                    .toList();
        }

        return List.of();
    }

    @Override
    public List<UserDto> findAll() {
        return ObjectMapper.map(userRepository.findAll(), UserDto.class);
    }

}
