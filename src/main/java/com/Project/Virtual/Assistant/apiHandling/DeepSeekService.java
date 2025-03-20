package com.Project.Virtual.Assistant.apiHandling;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Map;

@Service
public class DeepSeekService {

    @Value("${deepseek.api.url}")
    private String apiUrl;

    @Value("${deepseek.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public String getChatResponse(String userMessage) {
        // Request Body
        Map<String, Object> requestBody = Map.of(
            "model", "deepseek-chat",
            "messages", Collections.singletonList(Map.of("role", "user", "content", userMessage))
        );

        // Headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey); // Authorization

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        // API Call
        ResponseEntity<Map> response = restTemplate.exchange(apiUrl, HttpMethod.POST, entity, Map.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            Map<String, Object> responseBody = response.getBody();
            return responseBody.get("choices").toString(); // Extract AI Response
        }

        return "Error: Unable to fetch response from DeepSeek AI";
    }
}
