package com.Project.Virtual.Assistant.apiHandling;
import lombok.Data;

@Data
public class AutomationRequest {
//    private Long userId;
    private String taskTitle;
    private String taskDescription;
    private String platform;  // "zapier" or "make"
    
}
