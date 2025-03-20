package com.Project.Virtual.Assistant.apiHandling;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ChatRequestDTO {

    @Schema(description = "User message to send to Mistral AI", example = "Hello, how are you?")
    private String message;

}
