package com.Dimcooo.controllers;

import com.Dimcooo.model.UsersEntity;
import com.Dimcooo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/authorization")
public class AuthorizationController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signUp")
    public @ResponseBody String signUpUser(@ModelAttribute("userJSP") UsersEntity user){
//        return userService.RegisterUser(user);
        return "Everybody be cool";
    }
}
