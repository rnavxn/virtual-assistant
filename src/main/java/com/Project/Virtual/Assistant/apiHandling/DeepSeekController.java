package com.Project.Virtual.Assistant.apiHandling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/deepseek")
public class DeepSeekController {

    @Autowired
    private DeepSeekService deepSeekService;

    @PostMapping("/chat")
    public Map<String, String> chatWithDeepSeek(@RequestBody Map<String, String> request) {
        String userMessage = request.get("message");
        String response = deepSeekService.getChatResponse(userMessage);
        return Map.of("response", response);
    }
}
