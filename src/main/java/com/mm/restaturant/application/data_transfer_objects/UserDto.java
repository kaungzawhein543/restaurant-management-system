/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.mm.restaturant.application.data_transfer_objects;

import com.mm.restaturant.application.constants.UserRole;
import com.mm.restaturant.application.data_transfer_objects.custom_validations.ValidUsername;
import com.mm.restaturant.application.entities.User;
import com.mm.restaturant.application.utilities.object_mapper.Mappable;
import com.mm.restaturant.application.utilities.object_mapper.ValidMappable;
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
    @ValidUsername
    private String username;
    private UserRole role;
    private Integer age;
    private String name;
    private String email;

}
