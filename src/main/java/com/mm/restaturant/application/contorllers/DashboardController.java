/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.mm.restaturant.application.contorllers;

import com.mm.restaturant.application.services.UserService;
import com.mm.restaturant.application.utilities.WebUrl;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * DashboardController Class.
 * <p>
 * </p>
 *
 * @author Zwel Naing Oo
 */

@Controller
@RequiredArgsConstructor
public class DashboardController {

    private final UserService userService;

    @GetMapping(WebUrl.DASHBOARD_URL)
    public ModelAndView dashboard(HttpSession session){
        session.setAttribute("userRoleList", userService.getCurrentUserRoles());
        session.setAttribute("username", userService.getCurrentUsername());
        return new ModelAndView("dashboard");
    }

}
