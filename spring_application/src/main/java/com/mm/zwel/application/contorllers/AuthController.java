/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.mm.zwel.application.contorllers;

import com.mm.zwel.application.data_transfer_objects.LoginDto;
import com.mm.zwel.application.data_transfer_objects.RegisterDto;
import com.mm.zwel.application.services.UserService;
import com.mm.zwel.application.utilities.WebUrl;
import com.mm.zwel.application.utilities.object_mapper.NoPermissionObjectMappingException;
import com.sun.jdi.request.DuplicateRequestException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

import static com.mm.zwel.application.constants.ResponseStatus.*;
import static com.mm.zwel.application.utilities.CommonUtility.UniqueKey.*;

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

    private final UserService userService;

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
                userService.save(registerDto);
                return new ModelAndView("redirect:" + WebUrl.LOGIN_URL);
            } catch (DuplicateRequestException e) {
                return new ModelAndView("register", Map.of("user", registerDto, ERROR_MESSAGE, e.getMessage(), "status", FAILED));
            } catch (Exception e){
                return new ModelAndView("register", Map.of("user", registerDto, ERROR_MESSAGE, "An unexpected error occur.", "status", FAILED));
            }
        }
    }

}
