
package com.mm.restaurant.application.dtos;

import com.mm.restaurant.application.constants.UserRole;
import com.mm.restaurant.application.entities.User;
import com.mm.restaurant.application.utilities.object_mapper.Mappable;
import com.mm.restaurant.application.utilities.object_mapper.ValidMappable;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * UserDto Class.
 * <p>
 * </p>
 *
 * @author Zwel Naing Oo
 */
@Data
@ValidMappable(targets = {User.class})
public final class UserDto implements Mappable {
    @NotEmpty(message = "Username must not be empty.")
    private String username;
    private UserRole role;
    private Integer age;
    private String name;
    private String email;

}
