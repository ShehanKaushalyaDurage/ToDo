package com.todoapp.todo.domain.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreateTaskRequest {
    @NotEmpty(message = "TaskName cannot be empty.")
    private String taskName;
    @NotNull(message = "User cannot be empty.")
    private UUID userId;
    @NotEmpty(message = "Description cannot be empty.")
    private String description;
}
