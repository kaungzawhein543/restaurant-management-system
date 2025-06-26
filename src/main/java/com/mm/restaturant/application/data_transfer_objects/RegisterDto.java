/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.mm.restaturant.application.data_transfer_objects;

import com.mm.restaturant.application.data_transfer_objects.custom_validations.ValidPassword;
import com.mm.restaturant.application.data_transfer_objects.custom_validations.ValidUsername;
import com.mm.restaturant.application.entities.User;
import com.mm.restaturant.application.utilities.object_mapper.Mappable;
import com.mm.restaturant.application.utilities.object_mapper.ValidMappable;
import jakarta.validation.constraints.*;
import lombok.Data;

/**
 * RegisterDto Class.
 * <p>
 * </p>
 *
 * @author Zwel Naing Oo
 */
@Data
@ValidMappable(targets = {User.class})
public final class RegisterDto implements Mappable {
    @NotEmpty(message = "Username must not be empty.")
    @ValidUsername
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
    @Email
    private String email;

}