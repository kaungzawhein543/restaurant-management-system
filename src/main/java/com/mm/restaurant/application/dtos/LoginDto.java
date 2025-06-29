
package com.mm.restaurant.application.dtos;

import com.mm.restaurant.application.dtos.custom_validations.ValidPassword;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * LoginDto Class.
 * <p>
 * </p>
 *
 * @author Zwel Naing Oo
 */
@Data
public final class LoginDto{
    @NotEmpty(message = "Username must not be empty.")
    private String username;
    @NotEmpty(message = "Password must not be empty.")
    @ValidPassword
    private String password;
}