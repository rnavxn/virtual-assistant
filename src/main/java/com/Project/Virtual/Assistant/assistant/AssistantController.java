package com.Project.Virtual.Assistant.assistant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assistants")
public class AssistantController {

    @Autowired
    private AssistantService assistantService;

    @PostMapping
    public AssistantDTO saveAssistant(@RequestBody AssistantDTO assistantDTO) {
        return assistantService.saveAssistant(assistantDTO);
    }

    @GetMapping
    public List<AssistantDTO> getAllAssistants() {
        return assistantService.getAllAssistants();
    }

    @GetMapping("/{id}")
    public AssistantDTO getAssistantById(@PathVariable Long id) {
        return assistantService.getAssistantById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAssistant(@PathVariable Long id) {
        assistantService.deleteAssistant(id);
    }
}
