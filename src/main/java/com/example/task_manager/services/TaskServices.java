package com.example.task_manager.services;

import java.util.List;

import com.example.task_manager.model.Status;
import com.example.task_manager.model.Task;

public interface TaskServices {
    Task createTask(Task task);

    List<Task> getAllTasks(Status status);

    Task updateTask(Long id, Task task);

    Task updateStatus(Long id, Status status);

    void deleteTask(Long id);
}
