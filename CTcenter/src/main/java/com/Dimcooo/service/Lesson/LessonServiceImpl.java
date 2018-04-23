package com.Dimcooo.service.Lesson;

import com.Dimcooo.dao.Lesson.LessonDAO;
import com.Dimcooo.model.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {
    @Autowired
    private LessonDAO lessonDAO;

    @Override
    public List<Lesson> GetLessonsBySubjectById(int id) {
        return lessonDAO.GetDataFromLessonTable(id);
    }
}
