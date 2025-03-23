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
    //https://hook.eu2.make.com/ofqevfqb9rcifz84jppy4c1bm7adl3lu
    @PostMapping("/chat")
    public ResponseEntity<String> chatWithMistral(@RequestBody ChatRequest request) {
        return mistralChatService.getChatResponse(request.getMessage());
    }
}
