package com.Dimcooo.controller;

import com.Dimcooo.model.LoginUser;
import com.Dimcooo.model.User;
import com.Dimcooo.service.UserService;
import com.Dimcooo.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    private Validator validator = new Validator();

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
        //model.addAttribute("userJSP", new User());
        model.addAttribute("loginUser", new LoginUser());
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
    public String signInUser(@ModelAttribute("loginUser")LoginUser userToLogin, Model model){
        try {
            User user = userService.LoginUser(userToLogin.getLogin(), userToLogin.getPass());
            model.addAttribute("user", user);
            return "redirect:/signIn?success=true";
            //return "redirect:/start?userID=" + user.getUserId();
        }
        catch (Exception ex){
            return ex.getMessage();
        }
    }
}
