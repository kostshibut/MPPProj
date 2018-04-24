package com.Dimcooo.dao.Task;

import com.Dimcooo.model.Task;

import java.util.List;

public interface TaskDAO {
    List<Task> GetDataFromTaskTable(int id);
    boolean DeleteTask(Task task);
    Task CreateTask(Task task);
    Task FindTaskByTheme(String theme);
    Task FindTaskById(int taskId);
}
