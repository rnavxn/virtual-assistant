package com.Project.Virtual.Assistant.task;

import java.time.LocalDateTime;
import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Long userId, String title, String description) {
        Task task = new Task();
        task.setUserId(userId);
        task.setTitle(title);
        task.setDescription(description);
        task.setStatus(TaskStatus.PENDING);
        return taskRepository.save(task);
    }

    public void updateTaskStatus(Long taskId, TaskStatus status) {
        Task task = taskRepository.findById(taskId).orElse(null);
        if (task != null) {
            task.setStatus(status);
            task.setUpdatedAt(LocalDateTime.now());
            taskRepository.save(task);
        }
    }
    
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

}



