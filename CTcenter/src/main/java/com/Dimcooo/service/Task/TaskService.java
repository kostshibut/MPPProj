package com.Dimcooo.service.Task;

import com.Dimcooo.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> GetTaskByLessonId(int id);
}
