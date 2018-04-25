package com.Dimcooo.controller;

import com.Dimcooo.model.*;
import com.Dimcooo.service.Lesson.LessonService;
import com.Dimcooo.service.Scholar.ScholarService;
import com.Dimcooo.service.Task.TaskService;
import com.Dimcooo.service.Teacher.TeacherService;
import com.Dimcooo.service.User.UserService;
import com.Dimcooo.service.subject.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Time;

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

    @Autowired
    private LessonService lessonService;

    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "userControll", method = RequestMethod.GET)
    public ModelAndView imageUserControll(){
        ModelAndView modelAndView = new ModelAndView("AdminPages/userControll_page");
        modelAndView.addObject("teacherList", teacherService.GetListOfTeachers());
        modelAndView.addObject("scholarList", scholarService.GetAllScholars());
        return modelAndView;
    }

    @RequestMapping(value = "/deleteScholar/{id}", method = RequestMethod.GET)
    public String deleteScholar(HttpServletRequest request, @PathVariable("id")int scholarId){
        scholarService.DeleteScholar(scholarService.FindScholarById(scholarId));
        return "redirect:/userControll";
    }

    @RequestMapping(value = "/deleteTeacher/{id}", method = RequestMethod.GET)
    public String deleteTeacher(HttpServletRequest request, @PathVariable("id")int teacherId){
        teacherService.DeleteTeacher(teacherService.FindTeacherInfo(teacherId));
        return "redirect:/userControll";
    }

    @RequestMapping(value = "/deleteSubject/{id}", method = RequestMethod.GET)
    public String deleteSubject(@PathVariable("id") int subjectId){
        subjectService.DeleteSubject(subjectService.FindSubjectInfo(subjectId));
        return "redirect:/subjectList";
    }

    @RequestMapping(value = "/deleteLesson/{id}/{subjId}", method = RequestMethod.GET)
    public String deleteLesson(@PathVariable("id") int lessonId,
                               @PathVariable("subjId") int subjectId){
        lessonService.DeleteLesson(lessonService.FindLessonInfo(lessonId));
        return "redirect:/readmoreSubject/" + subjectId;
    }

    @RequestMapping(value = "/deleteTask/{id}/{lessonId}", method = RequestMethod.GET)
    public String deleteTask(@PathVariable("id") int taskId,
                             @PathVariable("lessonId") int lessonId){
        taskService.DeleteTask(taskService.FindTaskInfo(taskId));
        return "redirect:/readmoreSubject/" + subjectService.FindSubjectInfo(lessonService.FindLessonInfo(lessonId).getSubjectSubjectId()).getSubjectId();
    }

    @RequestMapping(value = "/createSubject/{teacherId}/{name}/{duration}", method = RequestMethod.GET)
    public String addSubject(@PathVariable("teacherId") int teacherId,
                             @PathVariable("name") String subjectName,
                             @PathVariable Integer duration){
        subjectService.SaveSubject(subjectName, duration, teacherId);
        return "redirect:/subjectList";
    }

    @RequestMapping(value = "/createLesson/{theme}/{duration}/{subjectId}", method = RequestMethod.GET)
    public String addLesson(@PathVariable("theme")String theme,
                            @PathVariable("duration")String timeLesson,
                            @PathVariable("subjectId")int subjectId){
        lessonService.SaveLesson(theme, timeLesson, subjectId);
        return "redirect:/readmoreSubject/" + subjectId;
    }

    @RequestMapping(value = "/createTask/{theme}/{content}/{lessonId}", method = RequestMethod.GET)
    public String addTask(@PathVariable("theme") String theme,
                          @PathVariable("content") String content,
                          @PathVariable("lessonId") int lessonId){
        taskService.SaveTask(theme, content, lessonId);
        return "redirect:/task/" + lessonId;
    }

    @RequestMapping(value = "/createTeacher/{scholarId}/{spetialization}", method = RequestMethod.GET)
    public String createTeacher(@PathVariable("scholarId") int scholarId,
                                      @PathVariable("spetialization") String spetialization){
        Scholar scholar = scholarService.FindScholarById(scholarId);
        User user = userService.FindUserById(scholar.getUserUserId());
        userService.SaveUser(user);
        scholarService.DeleteScholar(scholar);
        teacherService.CreateTeacher(user, spetialization);
        return "redirect:/userControll";
    }
}