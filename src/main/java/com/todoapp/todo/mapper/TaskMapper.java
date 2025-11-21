package com.todoapp.todo.mapper;

import com.todoapp.todo.domain.dto.CreateTaskRequest;
import com.todoapp.todo.domain.dto.CreateTaskResponse;
import com.todoapp.todo.domain.entity.TaskLIst;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface TaskMapper {
    @Mapping(target = "TaskLIst",source = "CreateTaskResponse")
    CreateTaskResponse toCreateTaskResponse(TaskLIst taskLIst);

    TaskLIst toTaskLIst(CreateTaskRequest createTaskRequest);
}
