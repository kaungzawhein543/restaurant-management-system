/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.mm.restaturant.application.services;

import com.mm.restaturant.application.constants.UserRole;
import com.mm.restaturant.application.data_transfer_objects.RegisterDto;
import com.mm.restaturant.application.data_transfer_objects.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * UserService Class.
 * <p>
 * </p>
 *
 * @author Zwel Naing Oo
 */

public interface UserService extends UserDetailsService {

    UserDto getUserByUsername(String username);

    UserDto save(UserDto userDto);

    UserDto save(RegisterDto registerDto);

    Boolean existUsername(String username);

    String getCurrentUsername();

    List<UserRole> getCurrentUserRoles();

    List<UserDto> findAll();
}
