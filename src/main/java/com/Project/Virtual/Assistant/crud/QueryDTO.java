package com.Project.Virtual.Assistant.crud;

import lombok.Data;

@Data
public class QueryDTO {
    private Long id;
    private String question;
    private String response;
    private String status;
}
