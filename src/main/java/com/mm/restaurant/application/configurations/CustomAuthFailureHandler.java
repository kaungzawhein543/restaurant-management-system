/***************************************************************
 * Author       :
 * Created Date :
 * Version      :
 * History  :
 * *************************************************************/
package com.mm.restaurant.application.configurations;

import com.mm.restaurant.application.utilities.CommonUtility;
import com.mm.restaurant.application.utilities.WebUrl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * CustomAuthFailureHandler Class.
 * <p>
 * </p>
 *
 * @author Zwel Naing Oo
 */

@Component
public class CustomAuthFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception)
            throws IOException {

        // Set a failure attribute in session or request
        request.getSession().setAttribute(CommonUtility.UniqueKey.LOGIN_ERROR, "Invalid username or password");
        // Forward internally to login page without query param
        response.sendRedirect(WebUrl.LOGIN_URL);
    }
}