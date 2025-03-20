package com.Project.Virtual.Assistant.query;

import lombok.Data;

@Data
public class QueryDTO {
    private Long id;
    private String question;
    private String response;
    private String status;
}
