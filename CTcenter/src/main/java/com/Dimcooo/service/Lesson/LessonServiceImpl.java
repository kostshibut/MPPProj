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
        return lessonDAO.GetDataFromLessonTable(id);
    }

    @Override
    public Lesson SaveLesson(String theme, String duration, int subjectId) {
        Lesson lesson = new Lesson();
        lesson.setTheme(theme);
        lesson.setDuration(duration);
        lesson.setSubjectSubjectId(subjectId);
        lessonDAO.CreateLesson(lesson);
        Lesson lessonByTheme = lessonDAO.FindLessonByTheme(lesson.getTheme());
        return lessonByTheme;
    }

    @Override
    public boolean DeleteLesson(Lesson lesson) {
        return lessonDAO.DeleteLesson(lesson);
    }

    @Override
    public Lesson FindLessonInfo(int lessonId) {
        return lessonDAO.FindSubjectById(lessonId);
    }
}
