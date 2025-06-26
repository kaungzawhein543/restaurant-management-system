/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.mm.restaturant.application.data_transfer_objects;

import com.mm.restaturant.application.data_transfer_objects.custom_validations.ValidPassword;
import com.mm.restaturant.application.data_transfer_objects.custom_validations.ValidUsername;
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
    @ValidUsername
    private String username;
    @NotEmpty(message = "Password must not be empty.")
    @ValidPassword
    private String password;
}