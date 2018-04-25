package com.Dimcooo.service.Lesson;

import com.Dimcooo.model.Lesson;

import java.sql.Time;
import java.util.List;

public interface LessonService {
    List<Lesson> GetLessonsBySubjectById(int id);
    Lesson SaveLesson(String theme, String duration, int subjectId);
    boolean DeleteLesson(Lesson lesson);
    Lesson FindLessonInfo(int lessonId);
}
