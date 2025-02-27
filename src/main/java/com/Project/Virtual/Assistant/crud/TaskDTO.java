package com.Project.Virtual.Assistant.crud;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TaskDTO {
    private Long id;
    private String title;
    private String description;
    private TaskStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long userId; // To store the associated user's ID
}
