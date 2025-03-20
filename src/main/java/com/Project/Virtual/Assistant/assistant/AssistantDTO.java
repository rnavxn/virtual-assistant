	package com.Project.Virtual.Assistant.assistant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssistantDTO {
    private Long id;
    private String name;
    private String description;
    private AssistantType type;
}
