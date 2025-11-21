package com.todoapp.todo.service;

import com.todoapp.todo.domain.dto.AuthorDto;
import com.todoapp.todo.domain.dto.RegisterDto;

public interface AuthenticationService {
    AuthorDto authenticate(String email, String password);
    void RegisterUser(RegisterDto registerDto);
}
