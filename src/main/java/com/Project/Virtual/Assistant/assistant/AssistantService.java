package com.Project.Virtual.Assistant.assistant;

import java.util.List;

public interface AssistantService {
    AssistantDTO saveAssistant(AssistantDTO assistantDTO);
    List<AssistantDTO> getAllAssistants();
    AssistantDTO getAssistantById(Long id);
    boolean deleteAssistant(Long id);
}
