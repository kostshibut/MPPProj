package com.Dimcooo.controller;

import com.Dimcooo.model.Error;
import com.Dimcooo.model.LoginUser;
import com.Dimcooo.model.User;
import com.Dimcooo.service.UserService;
import com.Dimcooo.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        return "signIn_page";
    }

    @RequestMapping(value = "signUp", method = RequestMethod.GET)
    public String signUpGet(@ModelAttribute("userUp")User user){
        return "signUp_page";
    }

    @RequestMapping(value = "signIn", method = RequestMethod.POST)
    public ModelAndView signInPost(@ModelAttribute("loginUser") LoginUser loginUser,
                                   HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView("start_page");
        User user = userService.FindByLogin(loginUser.getLogin());

//        if (Validator.AutentificationSignIn(user, loginUser)) {
//            modelAndView.addObject(user);
//        }
//        else {
//            Error error = new Error();
//            error.setName("Authentication error");
//            error.setDescription("Incorrect login or password");
//            modelAndView.setViewName("signIn_page");
//            modelAndView.addObject(error);
//        }
        request.getSession().setAttribute("loggedUser", user);
        return modelAndView;
    }

    @RequestMapping(value = "/personalArea", method = RequestMethod.GET)
    public ModelAndView persArea(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("personalArea_page");
        return modelAndView;
    }

    @RequestMapping(value = "signUp", method = RequestMethod.POST)
    public ModelAndView signUpPost(@ModelAttribute("userUp")User user){
        ModelAndView modelAndView = new ModelAndView("start_page");
        userService.SaveUser(user);
        modelAndView.addObject(user);
        return modelAndView;
    }
}
