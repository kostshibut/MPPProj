package com.Dimcooo.controllers;

import com.Dimcooo.model.UsersEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ConfigurationController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String startConfig(Model model){
        model.addAttribute("userJSP", new UsersEntity());
        return "start_page";
    }
}
