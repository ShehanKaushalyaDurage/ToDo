package com.todoapp.todo.service.impl;

import com.todoapp.todo.domain.dto.CreateTaskRequest;
import com.todoapp.todo.domain.dto.CreateTaskResponse;
import com.todoapp.todo.domain.entity.TaskLIst;
import com.todoapp.todo.domain.entity.User;
import com.todoapp.todo.mapper.TaskMapper;
import com.todoapp.todo.repo.TaskRepo;
import com.todoapp.todo.repo.UserRepo;
import com.todoapp.todo.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepo taskRepo;
    private final UserRepo userRepo;
    private final TaskMapper taskMapper;

    @Override
    public TaskLIst createTask(TaskLIst request) {
        User user = userRepo.findById(request.getUserId()).orElseThrow(()->new IllegalArgumentException("User not found"));

        TaskLIst task = TaskLIst.builder()
                .TaskName(request.getTaskName())
                .Description(request.getDescription())
                .user(user)
                .build();

        TaskLIst savedTask = taskRepo.save(task);
        return savedTask;
    }

    @Override
    public List<CreateTaskResponse> getTasksByUserId(UUID userId) {
        List<TaskLIst> tasks = taskRepo.findByUser_Id(userId);
        return tasks.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private CreateTaskResponse mapToResponse(TaskLIst task) {
        CreateTaskResponse response = new CreateTaskResponse();
        response.setTaskId(task.getTaskId());

        response.setTaskName(task.getTaskName());
        response.setDescription(task.getDescription());
        response.setUserId(task.getUser().getId());
        return response;
    }
}
