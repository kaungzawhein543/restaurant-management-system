//
//package com.mm.restaurant.application.contorllers;
//
//import com.mm.restaurant.application.services.UserService;
//import com.mm.restaurant.application.utilities.WebUrl;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
///**
// * UserController Class.
// * <p>
// * </p>
// *
// * @author Zwel Naing Oo
// */
//
//@Controller
//@RequiredArgsConstructor
//public class UserController {
//
//    private final UserService userService;
//
//    @GetMapping(WebUrl.USER_URL + "/{email}")
//    public ModelAndView getUser(@RequestParam String email){
//        return new ModelAndView("user", "user", userService.getUserByEmail(email));
//    }
//
//    @GetMapping(WebUrl.USER_URL)
//    public ModelAndView getUserList(){
//        return new ModelAndView("user-list", "userList", userService.findAll());
//    }
//
//}
