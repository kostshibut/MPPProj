package com.Dimcooo.controller;

import com.Dimcooo.model.User;
import com.Dimcooo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/", "start"}, method = RequestMethod.GET)
    public String startConfig(){
        return "start_page";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String jumpToPageGet(Model model){
        model.addAttribute("userJSP", new User());
        return "signUp_page";
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public String jumpToPageSignInGet(Model model){
        model.addAttribute("userJSP", new User());
        return "signIn_page";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String signUpUser(@ModelAttribute("userJSP")User user){
        try {
            userService.SaveUser(user);

            return "redirect:/signUp?success=true";
        }
        catch (Exception ex){
            return ex.getMessage();
        }
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String signInUser(@ModelAttribute("userJSP")User user){
        return "redirect:/signIn";
    }
}
