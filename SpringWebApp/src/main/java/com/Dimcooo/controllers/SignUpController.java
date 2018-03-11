package com.Dimcooo.controllers;

import com.Dimcooo.model.UsersEntity;
import com.Dimcooo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/signUp")
public class SignUpController {
    @Autowired
    private UserService userService;

    public @ResponseBody boolean signUpUser(UsersEntity user){
        return userService.RegisterUser(user);
    }
}
