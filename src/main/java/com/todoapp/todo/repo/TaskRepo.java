package com.todoapp.todo.repo;

import com.todoapp.todo.domain.entity.TaskLIst;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskRepo extends JpaRepository<TaskLIst, UUID> {
    List<TaskLIst> findByUser_Id(UUID userId);
}
