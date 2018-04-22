package com.Dimcooo.dao.Lesson;

import com.Dimcooo.model.Lesson;

import java.util.List;

public interface LessonDAO {
    List<Lesson> GetDataFromLessonTable(int Id);
}
