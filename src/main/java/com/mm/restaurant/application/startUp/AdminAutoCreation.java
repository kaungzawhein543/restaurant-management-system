package com.mm.restaurant.application.startUp;

import com.mm.restaurant.application.dtos.RegisterDto;
import com.mm.restaurant.application.entities.User;
import com.mm.restaurant.application.services.CrudService;
import com.mm.restaurant.application.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AdminAutoCreation implements CommandLineRunner {

    private final UserService userService;
    private final CrudService<User,Long> crudService;
    private final AdminProperties adminProperties;

    public AdminAutoCreation(UserService userService, CrudService<User,Long> crudService, AdminProperties adminProperties) {
        this.userService = userService;
        this.crudService = crudService;
        this.adminProperties = adminProperties;
    }

    @Override
    public void run(String... args) throws Exception {

        RegisterDto userDto = new RegisterDto();
        userDto.setName(adminProperties.getName());
        userDto.setAge(adminProperties.getAge());
        userDto.setEmail(adminProperties.getEmail());
        userDto.setPassword(adminProperties.getPassword());
        if (!userService.checkAdmin()) {
            crudService.save(userDto,RegisterDto.class);
        }
    }


}
