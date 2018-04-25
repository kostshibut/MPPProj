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
        try {
            return taskDAO.GetDataFromTaskTable(id);
        }
        catch (Exception ex){
            return null;
        }
    }

    @Override
    public Task SaveTask(String theme, String content, int lessonId) {
        try {
            Task task = new Task();
            task.setTheme(theme);
            task.setContent(content);
            task.setLessonLessonId(lessonId);
            taskDAO.CreateTask(task);
            return taskDAO.FindTaskByTheme(task.getTheme());
        }
        catch (Exception ex){
            return null;
        }
    }

    @Override
    public Task SaveTask(Task task) {
        try {
            return taskDAO.CreateTask(task);
        }
        catch (Exception ex){
            return null;
        }
    }

    @Override
    public boolean DeleteTask(Task task) {
        try {
            return taskDAO.DeleteTask(task);
        }
        catch (Exception ex){
            return false;
        }
    }

    @Override
    public Task FindTaskInfo(int taskId) {
        try {
            return taskDAO.FindTaskById(taskId);
        }
        catch (Exception ex) {
            return null;
        }
    }
}
