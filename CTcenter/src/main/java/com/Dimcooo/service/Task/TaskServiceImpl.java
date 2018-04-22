package com.Dimcooo.service.Task;

import com.Dimcooo.dao.Task.TaskDAO;
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
}
