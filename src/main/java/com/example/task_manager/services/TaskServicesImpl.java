package com.example.task_manager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.task_manager.model.Status;
import com.example.task_manager.model.Task;
import com.example.task_manager.repository.TaskRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TaskServicesImpl implements TaskServices {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskServicesImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks(Status status) {
        if (status != null) {
            return taskRepository.findByStatus(status);
        }

        return taskRepository.findAll();
    }

    @Override
    public Task updateTask(Long id, Task newTask) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));

        task.setDescription(newTask.getDescription());

        return taskRepository.save(task);
    }

    @Override
    public Task updateStatus(Long id, Status status) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));

        task.setStatus(status);

        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
