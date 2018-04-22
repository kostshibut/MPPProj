package com.Dimcooo.controller;

import com.Dimcooo.model.Scholar;
import com.Dimcooo.service.Scholar.ScholarService;
import com.Dimcooo.service.Teacher.TeacherService;
import com.Dimcooo.service.listScholarSubject.ListScholarSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminController {
    @Autowired
    private TeacherService teacherService;

    @Autowired
    private ScholarService scholarService;

    @RequestMapping(value = "userControll", method = RequestMethod.GET)
    public ModelAndView imageUserControll(){
        ModelAndView modelAndView = new ModelAndView("AdminPages/userControll_page");
        modelAndView.addObject("teacherList", teacherService.GetListOfTeachers());
        modelAndView.addObject("scholarList", scholarService.GetAllScholars());
        return modelAndView;
    }

    @RequestMapping(value = "/deleteScholar/{id}", method = RequestMethod.GET)
    public String deleteScholar(HttpServletRequest request, @PathVariable("id")int scholarId){
        Scholar scholar = scholarService.FindScholarById(scholarId);
        scholarService.DeleteScholar(scholar);
        return "redirect:/userControll";
    }
}
