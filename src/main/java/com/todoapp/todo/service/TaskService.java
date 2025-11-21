package com.todoapp.todo.service;

import com.todoapp.todo.domain.dto.CreateTaskRequest;
import com.todoapp.todo.domain.dto.CreateTaskResponse;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    CreateTaskResponse createTask(CreateTaskRequest request);
    List<CreateTaskResponse> getTasksByUserId(UUID userId);
}
