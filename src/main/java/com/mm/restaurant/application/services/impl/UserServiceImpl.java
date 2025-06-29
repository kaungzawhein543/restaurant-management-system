
package com.mm.restaurant.application.services.impl;

import com.mm.restaurant.application.constants.UserRole;
import com.mm.restaurant.application.dtos.RegisterDto;
import com.mm.restaurant.application.dtos.UserDto;
import com.mm.restaurant.application.entities.User;
//import com.mm.restaurant.application.repositories.UserRepository;
import com.mm.restaurant.application.repositories.UserRepository;
import com.mm.restaurant.application.services.CrudService;
import com.mm.restaurant.application.services.UserService;
import com.mm.restaurant.application.utilities.CommonUtility;
import com.mm.restaurant.application.utilities.object_mapper.ObjectMapper;
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


@Service
public class UserServiceImpl extends CrudService<User, Long> implements UserService {

    public UserServiceImpl(UserRepository userRepository) {
        super(userRepository, User.class);
    }

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return jpaRepository.findOne(Example.of(User.builder().email(email).build()))
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));
    }

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

    public List<UserRole> getCurrentUserRoles() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            return authentication.getAuthorities().stream()
                    .map(e -> UserRole.valueOf(e.getAuthority().replace("ROLE_", "")))
                    .toList();
        }

        return List.of();
    }


}
