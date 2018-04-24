package com.Dimcooo.service.Task;

import com.Dimcooo.dao.Task.TaskDAO;
import com.Dimcooo.model.Lesson;
import com.Dimcooo.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskDAO taskDAO;

    @Override
    public List<Task> GetTaskByLessonId(int id) {
        return taskDAO.GetDataFromTaskTable(id);
    }

    @Override
    public Task SaveTask(String theme, String content, int lessonId) {
        Task task = new Task();
        task.setTheme(theme);
        task.setContent(content);
        task.setLessonLessonId(lessonId);
        taskDAO.CreateTask(task);
        return taskDAO.FindTaskByTheme(task.getTheme());
    }

    @Override
    public boolean DeleteTask(Task task) {
        return taskDAO.DeleteTask(task);
    }

    @Override
    public Task FindTaskInfo(int taskId) {
        return taskDAO.FindTaskById(taskId);
    }
}
