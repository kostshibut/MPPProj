package com.Dimcooo.service.Task;

import com.Dimcooo.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> GetTaskByLessonId(int id);
    Task SaveTask(String theme, String content, int lessonId);
    Task SaveTask(Task task);
    boolean DeleteTask(Task task);
    Task FindTaskInfo(int taskId);
}
