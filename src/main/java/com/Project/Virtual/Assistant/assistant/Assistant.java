package com.Project.Virtual.Assistant.assistant;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "assistant")
@Data
@NoArgsConstructor
public class Assistant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    private AssistantType type; // CHATBOT, AUTOMATION
}
