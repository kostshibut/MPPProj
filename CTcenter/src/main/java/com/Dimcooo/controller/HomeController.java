package com.Dimcooo.controller;

import com.Dimcooo.model.Error;
import com.Dimcooo.model.LoginUser;
import com.Dimcooo.model.User;
import com.Dimcooo.service.ScholarService;
import com.Dimcooo.service.UserService;
import com.Dimcooo.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @Autowired
    private ScholarService scholarService;

    @RequestMapping(value = {"/", "start"}, method = RequestMethod.GET)
    public String startConfig(){
        return "start_page";
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public String signInGet(@ModelAttribute("loginUser") LoginUser loginUser){
        return "signIn_page";
    }

    @RequestMapping(value = "signUp", method = RequestMethod.GET)
    public String signUpGet(@ModelAttribute("userUp")User user){
        return "signUp_page";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/start?logout=true";
    }

    @RequestMapping(value = "personalArea", method = RequestMethod.GET)
    public ModelAndView personalArea(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("personalArea_page");
        return modelAndView;
    }

    @RequestMapping(value = "signIn", method = RequestMethod.POST)
    public ModelAndView signInPost(@ModelAttribute("loginUser") LoginUser loginUser, HttpServletRequest request) throws ServletException {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.FindByLogin(loginUser.getLogin());

        if (Validator.AutentificationSignIn(user, loginUser)) {
            modelAndView.setViewName("start_page");
            request.getSession().setAttribute("loggedUser", user);
        }
        else {
            Error error = new Error();
            modelAndView.setViewName("signIn_page");
            error.setName("Authentication error");
            error.setDescription("Incorrect login or password");
            modelAndView.addObject("error", error);
        }
        return modelAndView;
    }

    @RequestMapping(value = "signUp", method = RequestMethod.POST)
    public ModelAndView signUpPost(@ModelAttribute("userUp")User userForm, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        if (Validator.FindSimilarLogins(userForm.getLogin())) {
            modelAndView.setViewName("start_page");
            User user = userService.SaveUser(userForm);
            scholarService.AddScholar(user);
            request.getSession().setAttribute("loggedUser", user);
            System.out.println();
        }
        else
        {
            Error error = new Error();
            modelAndView.setViewName("signUp_page");
            error.setName("Authentication error");
            error.setDescription("Login already exists");
            modelAndView.addObject("error", error);
        }
        return modelAndView;
    }
}
