package com.Dimcooo.controller;

import com.Dimcooo.model.Error;
import com.Dimcooo.model.*;
import com.Dimcooo.service.Admin.AdminService;
import com.Dimcooo.service.Lesson.LessonService;
import com.Dimcooo.service.Scholar.ScholarService;
import com.Dimcooo.service.Task.TaskService;
import com.Dimcooo.service.Teacher.TeacherService;
import com.Dimcooo.service.TeacherFeedback.TeacherFeedbackService;
import com.Dimcooo.service.User.UserService;
import com.Dimcooo.service.listScholarSubject.ListScholarSubjectService;
import com.Dimcooo.service.subject.SubjectService;
import com.Dimcooo.validator.Validator;
import com.Dimcooo.validator.ViewValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private ListScholarSubjectService scholarSubjectService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private LessonService lessonService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private TeacherFeedbackService teacherFeedbackService;

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
        Scholar scholar = (Scholar) request.getSession().getAttribute("loggedScholar");
        if(scholar != null) {
            modelAndView.addObject("subbedSubject",
                    ViewValidator.ShowSignedList(scholarSubjectService.GetScholarSubject(scholar)));
        }
        return modelAndView;
    }

    @RequestMapping(value = "/createFeedback/{idTeacher}/{idScholar}", method = RequestMethod.GET)
    public ModelAndView imageFeedbackPage(@ModelAttribute("feedbackOnTeacher") TeacherFeedback teacherFeedback,
                                          @PathVariable("idTeacher") int teacherID, @PathVariable("idScholar")int scholarId){
        ModelAndView modelAndView = new ModelAndView("feedback_page");
        modelAndView.addObject("teacher", teacherService.FindTeacherInfo(teacherID));
        modelAndView.addObject("scholar", scholarService.FindScholarById(scholarId));
        return modelAndView;
    }

    @RequestMapping(value = "/createFeedback/{idTeacher}/{idScholar}", method = RequestMethod.POST)
    public ModelAndView createFeedback(@ModelAttribute("feedbackOnTeacher") TeacherFeedback teacherFeedback,
                                 @PathVariable("idTeacher") int idTeacher, @PathVariable("idScholar")int idScholar){
        ModelAndView modelAndView = new ModelAndView();

        if (ViewValidator.isHaveFeedback(teacherFeedbackService.GetScholarFeedback(scholarService.FindScholarById(idScholar)),
                scholarService.FindScholarById(idScholar), teacherService.FindTeacherInfo(idTeacher))) {
            modelAndView.setViewName("start_page");
            teacherFeedbackService.AddTeacherFeedback(teacherFeedback, teacherService.FindTeacherInfo(idTeacher),
                    scholarService.FindScholarById(idScholar));
        }
        else {
            Error error = new Error();
            modelAndView.setViewName("feedback_page");
            error.setName("Feedback Error");
            error.setDescription("You already have the feedback on this teacher");
            modelAndView.addObject(error);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/readmoreSubject/{id}")
    public ModelAndView imageReadmoreSubject(@PathVariable("id") int subjectID){
        ModelAndView modelAndView = new ModelAndView("oneSubject_page");
        modelAndView.addObject("subject", subjectService.FindSubjectInfo(subjectID));
        modelAndView.addObject("lessonForSubject", lessonService.GetLessonsBySubjectById(subjectID));
        return modelAndView;
    }

    @RequestMapping(value = "/task/{id}")
    public ModelAndView imageTask(@PathVariable("id") int lessonID){
        ModelAndView modelAndView = new ModelAndView("task_page");
        modelAndView.addObject("taskForSubject", taskService.GetTaskByLessonId(lessonID));
        modelAndView.addObject("lessonId", lessonID);
        return modelAndView;
    }

    @RequestMapping(value = "/readmoreTeacher/{id}")
    public ModelAndView imageReadmoreTeacher(@PathVariable("id") int teacherID){
        ModelAndView modelAndView = new ModelAndView("oneTeacher_page");
        modelAndView.addObject("teacher", teacherService.FindTeacherInfo(teacherID));
        modelAndView.addObject("teacherFeedback", teacherFeedbackService.GetTeacherFeedback(teacherID));
        return modelAndView;
    }

    @RequestMapping(value = "subjectList", method = RequestMethod.GET)
    public ModelAndView imageSubjectListGet(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("subjects_page");
        Scholar scholar = (Scholar)request.getSession().getAttribute("loggedScholar");
        if (scholar != null) {
            modelAndView.addObject("listOfUnSignedSubjects",
                    ViewValidator.ShowUnSignedSubjects(scholar,
                            subjectService.GetListOfSubjects(),
                            scholarSubjectService.GetAllScholars()));

            modelAndView.addObject("signedSubject",
                    ViewValidator.ShowSignedList(scholarSubjectService.GetScholarSubject((Scholar) request.getSession().getAttribute("loggedScholar"))));
        }
        else {
            modelAndView.addObject("listOfUnSignedSubjects", subjectService.GetListOfSubjects());
        }

        if(request.getSession().getAttribute("loggedAdmin") != null){
            modelAndView.addObject("teacherList", teacherService.GetListOfTeachers());
        }

        return modelAndView;
    }

    @RequestMapping(value = "teacherList", method = RequestMethod.GET)
    public ModelAndView imageTeachersList(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("teachers_page");
        modelAndView.addObject("listOfTeachers", teacherService.GetListOfTeachers());
        return modelAndView;
    }

    @RequestMapping(value = "/enroll/{id}", method = RequestMethod.POST)
    public String enrollToSubject(@PathVariable("id")int subjectID, HttpServletRequest request){
        scholarSubjectService.EnrollScholarToSubject((Scholar) request.getSession().getAttribute("loggedScholar"),
                subjectService.FindSubjectInfo(subjectID));
        return "redirect:/subjectList";
    }

    @RequestMapping(value = "signIn", method = RequestMethod.POST)
    public ModelAndView signInPost(@ModelAttribute("loginUser") LoginUser loginUser, HttpServletRequest request) throws ServletException {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.FindByLogin(loginUser.getLogin());

        if (Validator.AutentificationSignIn(user, loginUser)) {
            modelAndView.setViewName("start_page");
            if (adminService.FindAdminByUser(user) != null){
                request.getSession().setAttribute("loggedAdmin", adminService.FindAdminByUser(user));
            }
            if (teacherService.FindTeacherByUser(user) != null){
                request.getSession().setAttribute("loggedTeacher", teacherService.FindTeacherByUser(user));
            }
            if (scholarService.FindScholarByUser(user) != null){
                request.getSession().setAttribute("loggedScholar", scholarService.FindScholarByUser(user));
            }
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