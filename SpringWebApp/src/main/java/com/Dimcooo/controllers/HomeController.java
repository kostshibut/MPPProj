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

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String startConfig(){
        return "start_page";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String jumpToPageGet(Model model){
        model.addAttribute("userJSP", new UsersEntity());
        return "signUp_page";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public @ResponseBody
    String signUpUser(@ModelAttribute("userJSP") UsersEntity user){
        return "Everybody be cool";
    }
}
