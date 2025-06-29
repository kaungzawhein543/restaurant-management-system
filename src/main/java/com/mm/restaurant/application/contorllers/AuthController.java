
package com.mm.restaurant.application.contorllers;

import com.mm.restaurant.application.dtos.LoginDto;
import com.mm.restaurant.application.dtos.RegisterDto;
import com.mm.restaurant.application.entities.User;
import com.mm.restaurant.application.services.CrudService;
import com.mm.restaurant.application.utilities.WebUrl;
import com.sun.jdi.request.DuplicateRequestException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

import static com.mm.restaurant.application.constants.ResponseStatus.*;
import static com.mm.restaurant.application.utilities.CommonUtility.UniqueKey.*;

/**
 * AuthController Class.
 * <p>
 * </p>
 *
 * @author Zwel Naing Oo
 */

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final CrudService<User, Long> userService;

    @GetMapping(WebUrl.AUTH_URL)
    public String auth() {
        return "redirect:" + WebUrl.LOGIN_URL;
    }

    @GetMapping(WebUrl.LOGIN_URL)
    public ModelAndView login(HttpServletRequest request) {
        Object error = request.getSession().getAttribute(LOGIN_ERROR);
        request.getSession().removeAttribute(LOGIN_ERROR);
        return new ModelAndView("login", Map.of("status", error != null ? FAILED : PENDING, "user", new LoginDto()));
    }

    @GetMapping(WebUrl.REGISTER_URL)
    public ModelAndView register() {
        return new ModelAndView("register", "user", new RegisterDto());
    }

    @PostMapping(WebUrl.REGISTER_URL)
    public ModelAndView register(@ModelAttribute("user") @Valid RegisterDto registerDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("register", "user", registerDto);
        } else {
            try {
                userService.save(registerDto,RegisterDto.class);
                return new ModelAndView("redirect:" + WebUrl.LOGIN_URL);
            } catch (DuplicateRequestException e) {
                return new ModelAndView("register", Map.of("user", registerDto, ERROR_MESSAGE, e.getMessage(), "status", FAILED));
            } catch (Exception e){
                return new ModelAndView("register", Map.of("user", registerDto, ERROR_MESSAGE, "An unexpected error occur.", "status", FAILED));
            }
        }
    }

}
