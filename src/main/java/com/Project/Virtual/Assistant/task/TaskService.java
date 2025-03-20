package com.Project.Virtual.Assistant.task;

import java.util.List;

public interface TaskService {
    Task createTask(Task task);
    Task getTaskById(Long id);
    List<Task> getAllTasks();
    List<Task> getTasksByUserId(Long userId);
    Task updateTask(Long id, Task task);
    void deleteTask(Long id);
}
