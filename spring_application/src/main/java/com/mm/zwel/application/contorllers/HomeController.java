/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.mm.zwel.application.contorllers;

import com.mm.zwel.application.services.UserService;
import com.mm.zwel.application.utilities.WebUrl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * HomeController Class.
 * <p>
 * </p>
 *
 * @author Zwel Naing Oo
 */

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final UserService userService;

    @GetMapping(WebUrl.BASE_URL)
    public String home(){
        if(userService.getCurrentUsername() != null){
            return "redirect:" + WebUrl.AUTH_URL;
        }else {
            return "redirect:" + WebUrl.DASHBOARD_URL;
        }
    }
}
