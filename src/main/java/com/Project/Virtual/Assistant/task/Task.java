package com.Project.Virtual.Assistant.task;

import jakarta.persistence.*;

import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
public class Task {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String platform;
}
