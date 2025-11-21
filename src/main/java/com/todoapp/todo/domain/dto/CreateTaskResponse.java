package com.todoapp.todo.domain.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CreateTaskResponse {
    private UUID taskId;
    private String taskName;
    private UUID userId;
    private String description;
}
