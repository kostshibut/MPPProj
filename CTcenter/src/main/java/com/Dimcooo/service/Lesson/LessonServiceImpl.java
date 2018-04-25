package com.Dimcooo.service.Lesson;

import com.Dimcooo.dao.Lesson.LessonDAO;
import com.Dimcooo.model.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {
    @Autowired
    private LessonDAO lessonDAO;

    @Override
    public List<Lesson> GetLessonsBySubjectById(int id) {
        try {
            return lessonDAO.GetDataFromLessonTable(id);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Lesson SaveLesson(String theme, String duration, int subjectId) {
        try {
            Lesson lesson = new Lesson();
            lesson.setTheme(theme);
            lesson.setDuration(duration);
            lesson.setSubjectSubjectId(subjectId);
            lessonDAO.CreateLesson(lesson);
            Lesson lessonByTheme = lessonDAO.FindLessonByTheme(lesson.getTheme());
            return lessonByTheme;
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public boolean DeleteLesson(Lesson lesson) {
        try {
            return lessonDAO.DeleteLesson(lesson);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public Lesson FindLessonInfo(int lessonId) {
        try {
            return lessonDAO.FindSubjectById(lessonId);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
