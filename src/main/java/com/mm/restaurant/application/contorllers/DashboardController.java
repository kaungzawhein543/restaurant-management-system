
package com.mm.restaurant.application.contorllers;

import com.mm.restaurant.application.dtos.UserDto;
import com.mm.restaurant.application.services.impl.UserServiceImpl;
import com.mm.restaurant.application.utilities.WebUrl;
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

    private final UserServiceImpl userService;

    @GetMapping(WebUrl.DASHBOARD_URL)
    public ModelAndView dashboard(HttpSession session){
        session.setAttribute("userRoleList", userService.getCurrentUserRoles());
        session.setAttribute("username", userService.getCurrentUsername());
        return new ModelAndView("dashboard");
    }

}
