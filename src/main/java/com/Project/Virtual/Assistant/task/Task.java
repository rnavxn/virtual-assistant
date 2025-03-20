package com.Project.Virtual.Assistant.task;

import jakarta.persistence.*;

import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "task")
public class Task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title; // (e.g., "Send Email via Zapier")

    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status; // PENDING, IN_PROGRESS, COMPLETED

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Long userId; // User who triggered it

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

}
