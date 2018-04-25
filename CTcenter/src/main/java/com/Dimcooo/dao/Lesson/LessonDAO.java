package com.Dimcooo.dao.Lesson;

import com.Dimcooo.model.Lesson;

import java.util.List;

public interface LessonDAO {
    List<Lesson> GetDataFromLessonTable(int Id);
    boolean DeleteLesson(Lesson lesson);
    Lesson CreateLesson(Lesson lesson);
    Lesson FindLessonByTheme(String themeLesson);
    Lesson FindSubjectById(int lessonId);
}