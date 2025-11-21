package com.todoapp.todo.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskLIst {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID taskId;
    @Column(nullable = false)
    private String TaskName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @Column(nullable = false)
    private String password;
}
