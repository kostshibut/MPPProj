package com.Dimcooo.controllers;

import com.Dimcooo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @RequestMapping(value = {"/", "start"}, method = RequestMethod.GET)
    public String startConfig(){
        return "start_page";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String jumpToPageGet(Model model){
        model.addAttribute("userJSP", new User());
        return "signUp_page";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public @ResponseBody
    String signUpUser(@ModelAttribute("userJSP") User user){

        return "Everybody be cool";
    }
}
