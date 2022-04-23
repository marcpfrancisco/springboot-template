package com.marcpfrancisco.springtemplate.dto;

import lombok.Data;

@Data
public class ToDosDTO {
    private long todoId;
    private String title;
    private String description;
    private boolean is_completed;
}
