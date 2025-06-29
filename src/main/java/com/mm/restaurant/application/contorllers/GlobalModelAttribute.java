
package com.mm.restaurant.application.contorllers;

import com.mm.restaurant.application.constants.ResponseStatus;
import com.mm.restaurant.application.constants.UserRole;
import com.mm.restaurant.application.utilities.CommonUtility;
import com.mm.restaurant.application.utilities.WebUrl;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;


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
