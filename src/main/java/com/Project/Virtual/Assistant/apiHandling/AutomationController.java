package com.Project.Virtual.Assistant.apiHandling;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/automation")
public class AutomationController {

    private final AutomationService automationService;

    public AutomationController(AutomationService automationService) {
        this.automationService = automationService;
    }

    @PostMapping("/trigger")
    public String triggerAutomation(@RequestBody AutomationRequest request) {
        return automationService.triggerAutomation(request);
    }
}
