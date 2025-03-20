package com.Project.Virtual.Assistant.apiHandling;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/automation")
public class AutomationController {

    private final AutomationService automationService;

    public AutomationController(AutomationService automationService) {
        this.automationService = automationService;
    }

    @PostMapping("/trigger")
    public String triggerAutomation(@RequestBody Map<String, Object> requestPayload) {
        return automationService.triggerAutomation(requestPayload, (String) requestPayload.get("platform"));
    }
}

