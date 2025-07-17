package com.mm.restaurant.application.startUp;

import com.mm.restaurant.application.dtos.RegisterDto;
import com.mm.restaurant.application.entities.User;
import com.mm.restaurant.application.utilities.object_mapper.Mappable;
import com.mm.restaurant.application.utilities.object_mapper.ValidMappable;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ValidMappable(targets = {User.class, RegisterDto.class})
@ConfigurationProperties(prefix = "admin")
public class AdminProperties implements Mappable {
    private String name;
    private String email;
    private int age;
    private String password;
}
