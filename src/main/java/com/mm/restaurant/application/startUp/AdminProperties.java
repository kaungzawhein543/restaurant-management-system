package com.mm.restaurant.application.startUp;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "admin")
public class AdminProperties {
    private String name;
    private String email;
    private int age;
    private String password;
}
