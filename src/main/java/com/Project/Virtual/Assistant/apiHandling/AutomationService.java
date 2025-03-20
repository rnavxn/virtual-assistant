package com.Project.Virtual.Assistant.apiHandling;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class AutomationService {

    @Value("${zapier.webhook.url}")
    private String zapierWebhookUrl;

    @Value("${make.webhook.url}")
    private String makeWebhookUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public String triggerAutomation(Map<String, Object> payload, String platform) {
        String webhookUrl = "zapier".equalsIgnoreCase(platform) ? zapierWebhookUrl :
                            "make".equalsIgnoreCase(platform) ? makeWebhookUrl : null;

        if (webhookUrl == null) {
            return "Invalid platform: " + platform;
        }

        return restTemplate.postForObject(webhookUrl, payload, String.class);
    }
}
