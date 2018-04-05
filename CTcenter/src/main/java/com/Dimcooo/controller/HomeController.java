package com.Dimcooo.controller;

import com.Dimcooo.model.LoginUser;
import com.Dimcooo.model.User;
import com.Dimcooo.service.UserService;
import com.Dimcooo.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("user")
public class HomeController {
    @Autowired
    private UserService userService;


    @RequestMapping(value = {"/", "start"}, method = RequestMethod.GET)
    public String startConfig(){
        return "start_page";
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public String signInGet(@ModelAttribute("loginUser") LoginUser loginUser){
        //httpSession.setAttribute("user", new LoginUser());
        return "signIn_page";
    }

    @RequestMapping(value = "signIn", method = RequestMethod.POST)
    public ModelAndView signInPost(@ModelAttribute("loginUser") LoginUser loginUser){
        ModelAndView modelAndView = new ModelAndView("start_page");
        User user = userService.LoginUser(loginUser.getLogin(), loginUser.getPass());
        modelAndView.addObject(user);
        return modelAndView;
    }
}
