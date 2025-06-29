//
//package com.mm.restaurant.application.configurations;
//
//import com.mm.restaurant.application.services.UserService;
//import com.mm.restaurant.application.utilities.WebUrl;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
///**
// * SpringSecurity Class.
// * <p>
// * </p>
// *
// * @author Zwel Naing Oo
// */
//
//@Configuration
//@RequiredArgsConstructor
//public class SpringSecurity {
//
//    private final CustomAuthFailureHandler customAuthFailureHandler;
//    private final UserService userService;
//    private final PasswordEncoder passwordEncoder;
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        return http
//                .authorizeHttpRequests(request -> request
//                        .requestMatchers(WebUrl.AUTH_URL + "/**").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .formLogin(login -> login
//                        .loginPage(WebUrl.LOGIN_URL)
//                        .loginProcessingUrl(WebUrl.LOGIN_URL)
//                        .failureHandler(customAuthFailureHandler)
//                        .defaultSuccessUrl(WebUrl.DASHBOARD_URL, true)
//                )
//                .logout(logout -> logout
//                        .logoutUrl(WebUrl.LOGOUT_URL)
//                        .logoutSuccessUrl(WebUrl.LOGIN_URL)
//                        .invalidateHttpSession(true)
//                        .clearAuthentication(true)
//                        .deleteCookies("JSESSIONID")
//                )
//                .build();
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
//        AuthenticationManagerBuilder builder = http.getSharedObject(AuthenticationManagerBuilder.class);
//        builder.userDetailsService(userService).passwordEncoder(passwordEncoder);
//        return builder.build();
//    }
//
//}
//
