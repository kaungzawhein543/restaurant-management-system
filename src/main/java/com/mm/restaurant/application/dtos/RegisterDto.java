
package com.mm.restaurant.application.dtos;

import com.mm.restaurant.application.dtos.custom_validations.ValidPassword;
import com.mm.restaurant.application.entities.User;
import com.mm.restaurant.application.utilities.object_mapper.Mappable;
import com.mm.restaurant.application.utilities.object_mapper.ValidMappable;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@ValidMappable(targets = {User.class})
public final class RegisterDto implements Mappable {
    @NotEmpty(message = "Username must not be empty.")
    private String username;
    @NotEmpty(message = "Name must not be empty.")
    private String name;
    @NotEmpty(message = "Password must not be empty.")
    @ValidPassword
    private String password;
    @Min(value = 18, message = "Age must be at least 18 years old.")
    @Max(value = 80, message = "Age does not exceed 80 years old.")
    private Integer age;
    @NotEmpty(message = "Email must not be empty.")
    @Email(message = "Incorrect email.")
    private String email;

}