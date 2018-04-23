package com.Dimcooo.controller;

import com.Dimcooo.model.Scholar;
import com.Dimcooo.model.Subject;
import com.Dimcooo.model.Teacher;
import com.Dimcooo.model.User;
import com.Dimcooo.service.Scholar.ScholarService;
import com.Dimcooo.service.Teacher.TeacherService;
import com.Dimcooo.service.User.UserService;
import com.Dimcooo.service.subject.SubjectService;
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

    @Autowired
    private UserService userService;

    @Autowired
    private SubjectService subjectService;

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

    @RequestMapping(value = "/deleteTeacher/{id}", method = RequestMethod.GET)
    public String deleteTeacher(HttpServletRequest request, @PathVariable("id")int teacherId){
        Teacher teacher = teacherService.FindTeacherInfo(teacherId);
        teacherService.DeleteTeacher(teacher);
        return "redirect:/userControll";
    }

    @RequestMapping(value = "/deleteSubject/{id}", method = RequestMethod.GET)
    public String deleteSubject(@PathVariable("id") int subjectId){
        Subject subject = subjectService.FindSubjectInfo(subjectId);
        subjectService.DeleteSubject(subject);
        return "redirect:/subjectList";
    }

    @RequestMapping(value = "/createSubject/{teacherId}/{name}/{duration}", method = RequestMethod.GET)
    public String addSubject(@PathVariable("teacherId") int teacherId,
                             @PathVariable("name") String subjectName,
                             @PathVariable Integer duration){
        subjectService.SaveSubject(subjectName, duration, teacherId);
        return "redirect:/subjectList";
    }

    @RequestMapping(value = "/createTeacher/{scholarId}/{spetialization}", method = RequestMethod.GET)
    public ModelAndView createTeacher(@PathVariable("scholarId") int scholarId,
                                      @PathVariable("spetialization") String spetialization){

        ModelAndView modelAndView = new ModelAndView("start_page");

        Scholar scholar = scholarService.FindScholarById(scholarId);
        User user = userService.FindUserById(scholar.getUserUserId());
        userService.SaveUser(user);
        scholarService.DeleteScholar(scholar);
        teacherService.CreateTeacher(user, spetialization);

        return modelAndView;
    }
}
