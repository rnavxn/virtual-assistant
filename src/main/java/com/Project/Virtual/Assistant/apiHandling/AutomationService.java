package com.Project.Virtual.Assistant.apiHandling;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Project.Virtual.Assistant.task.Task;
import com.Project.Virtual.Assistant.task.TaskService;

@Service
public class AutomationService {

    @Value("${zapier.webhook.url}")
    private String zapierWebhookUrl;

    @Value("${make.webhook.url}")
    private String makeWebhookUrl;

    private final RestTemplate restTemplate;
    private final TaskService taskService;

    public AutomationService(RestTemplate restTemplate, TaskService taskService) {
        this.restTemplate = restTemplate;
        this.taskService = taskService;
    }

    public String triggerAutomation(AutomationRequest request) {
        String platform = request.getPlatform();
        String webhookUrl = "zapier".equalsIgnoreCase(platform) ? zapierWebhookUrl :
                            "make".equalsIgnoreCase(platform) ? makeWebhookUrl : null;

        if (webhookUrl == null) {
            return "Invalid platform: " + platform;
        }

        // Send the automation request to Zapier/Make
        String response = restTemplate.postForObject(webhookUrl, request, String.class);

        // Save the task in the Task module
        Task newTask = new Task();
        newTask.setTitle(request.getTaskTitle());
        newTask.setDescription(request.getTaskDescription());
        newTask.setPlatform(request.getPlatform());

        taskService.saveTask(newTask); // Save to database

        return response;
    }
}
