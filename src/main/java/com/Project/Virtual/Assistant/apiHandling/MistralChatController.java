package com.Project.Virtual.Assistant.apiHandling;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mistral")
public class MistralChatController {

    private final MistralChatService mistralChatService;

    public MistralChatController(MistralChatService mistralChatService) {
        this.mistralChatService = mistralChatService;
    }

    @PostMapping("/chat")
    public ResponseEntity<String> chatWithMistral(@RequestBody ChatRequestDTO request) {
        return mistralChatService.getChatResponse(request.getMessage());
    }
}
