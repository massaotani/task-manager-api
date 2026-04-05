package com.example.task_manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.task_manager.model.Status;
import com.example.task_manager.model.Task;
import com.example.task_manager.services.TaskServices;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskServices service;

    @Autowired
    public TaskController(TaskServices service) {
        this.service = service;
    }

    // 1. ADD a task (Requirement: task-cli add "description")
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return ResponseEntity.ok().body(service.createTask(task));
    }

    // 2. LIST ALL tasks (Requirement: task-cli list)
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(@RequestParam(required = false) Status status) {
            return ResponseEntity.ok().body(service.getAllTasks(status));
    }

    // 3. UPDATE a task (Requirement: task-cli update id "description")
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task newTask) {
        return ResponseEntity.ok().body(service.updateTask(id, newTask));
    }

    // 4. UPDATE a Status - Mark In-Progress / Done (Requirement: task-cli
    // mark-in-progress 1)
    @PatchMapping("/{id}")
    public ResponseEntity<Task> updateStatus(@PathVariable Long id, @RequestParam Status status) {
        return ResponseEntity.ok().body(service.updateStatus(id, status));
    }

    // 5. DELETE a task
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
        
        return ResponseEntity.noContent().build();
    }
}