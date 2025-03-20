package com.Project.Virtual.Assistant.assistant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AssistantServiceImpl implements AssistantService {

    @Autowired
    private AssistantRepository assistantRepository;

    @Override
    public AssistantDTO saveAssistant(AssistantDTO assistantDTO) {
        Assistant assistant = new Assistant();
        assistant.setName(assistantDTO.getName());
        assistant.setDescription(assistantDTO.getDescription());
        assistant.setType(assistantDTO.getType());

        Assistant savedAssistant = assistantRepository.save(assistant);
        return new AssistantDTO(savedAssistant.getId(), savedAssistant.getName(), savedAssistant.getDescription(), savedAssistant.getType());
    }

    @Override
    public List<AssistantDTO> getAllAssistants() {
        List<Assistant> assistants = assistantRepository.findAll();
        return assistants.stream()
                .map(a -> new AssistantDTO(a.getId(), a.getName(), a.getDescription(), a.getType()))
                .collect(Collectors.toList());
    }

    @Override
    public AssistantDTO getAssistantById(Long id) {
        Optional<Assistant> assistant = assistantRepository.findById(id);
        if (assistant.isPresent()) {
            Assistant a = assistant.get();
            return new AssistantDTO(a.getId(), a.getName(), a.getDescription(), a.getType());
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteAssistant(Long id) {
        Optional<Assistant> assistant = assistantRepository.findById(id);
        if (assistant.isPresent()) {
            assistantRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}

