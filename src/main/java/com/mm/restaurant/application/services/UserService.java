package com.mm.restaurant.application.services;

import com.mm.restaurant.application.constants.UserRole;
import com.mm.restaurant.application.dtos.RegisterDto;
import com.mm.restaurant.application.dtos.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService  {

    String getCurrentUsername();

    List<UserRole> getCurrentUserRoles();


}
