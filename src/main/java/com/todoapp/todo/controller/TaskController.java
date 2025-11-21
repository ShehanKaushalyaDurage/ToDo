package com.todoapp.todo.controller;

import com.todoapp.todo.domain.dto.CreateTaskRequest;
import com.todoapp.todo.domain.dto.CreateTaskResponse;
import com.todoapp.todo.mapper.TaskMapper;
import com.todoapp.todo.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    @PostMapping("/register")
    public ResponseEntity<CreateTaskResponse> createTask(@Valid @RequestBody CreateTaskRequest request) {
        CreateTaskResponse createTaskResponse = taskMapper.toTaskLIst(request);
        CreateTaskResponse task = taskService.createTask(createTaskResponse);

        return new ResponseEntity<>(taskMapper.toCreateTaskResponse(task),HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CreateTaskResponse>> getTasksByUser(@PathVariable UUID userId) {
        return ResponseEntity.ok(taskService.getTasksByUserId(userId));
    }
}
