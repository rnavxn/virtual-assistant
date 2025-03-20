package com.Project.Virtual.Assistant.apiHandling;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Map;

@Service
public class MistralChatService {

    private final RestTemplate restTemplate;

    @Value("${mistral.api.url}")
    private String mistralApiUrl;

    @Value("${mistral.api.key}")
    private String mistralApiKey;

    public MistralChatService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> getChatResponse(String userMessage) {
        // Construct request body
        Map<String, Object> requestBody = Map.of(
            "model", "mistral-small",
            "messages", Collections.singletonList(Map.of("role", "user", "content", userMessage)),
            "max_tokens", 50
        );

        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(mistralApiKey);

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

        // Make API call
        return restTemplate.exchange(mistralApiUrl, HttpMethod.POST, requestEntity, String.class);
    }
}
