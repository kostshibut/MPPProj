package com.Dimcooo.service.Lesson;

import com.Dimcooo.model.Lesson;

import java.util.List;

public interface LessonService {
    List<Lesson> GetLessonsForSubjectById(int id);
}
