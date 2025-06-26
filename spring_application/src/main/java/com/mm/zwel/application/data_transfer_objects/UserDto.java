/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.mm.zwel.application.data_transfer_objects;

import com.mm.zwel.application.constants.UserRole;
import com.mm.zwel.application.data_transfer_objects.custom_validations.ValidUsername;
import com.mm.zwel.application.entities.User;
import com.mm.zwel.application.utilities.object_mapper.Mappable;
import com.mm.zwel.application.utilities.object_mapper.ValidMappable;
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
