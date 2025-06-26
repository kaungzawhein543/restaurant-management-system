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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * UserController Class.
 * <p>
 * </p>
 *
 * @author Zwel Naing Oo
 */

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(WebUrl.USER_URL + "/{username}")
    public ModelAndView getUser(@RequestParam String username){
        return new ModelAndView("user", "user", userService.getUserByUsername(username));
    }

    @GetMapping(WebUrl.USER_URL)
    public ModelAndView getUserList(){
        return new ModelAndView("user-list", "userList", userService.findAll());
    }

}
