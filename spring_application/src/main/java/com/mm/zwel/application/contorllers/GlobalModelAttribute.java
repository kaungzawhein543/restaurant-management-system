/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.mm.zwel.application.contorllers;

import com.mm.zwel.application.constants.ResponseStatus;
import com.mm.zwel.application.constants.UserRole;
import com.mm.zwel.application.utilities.CommonUtility;
import com.mm.zwel.application.utilities.WebUrl;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * GlobalModelAttribute Class.
 * <p>
 * </p>
 *
 * @author Zwel Naing Oo
 */

@ControllerAdvice
public class GlobalModelAttribute {

    @ModelAttribute("ResponseStatus")
    public Class<ResponseStatus> responseStatus(){
        return ResponseStatus.class;
    }

    @ModelAttribute("UserRole")
    public Class<UserRole> userRole(){
        return UserRole.class;
    }

    @ModelAttribute("CommonUtility")
    public Class<CommonUtility> commonUtility(){
        return CommonUtility.class;
    }

    @ModelAttribute("WebUrl")
    public Class<WebUrl> webUtl(){
        return WebUrl.class;
    }
}
