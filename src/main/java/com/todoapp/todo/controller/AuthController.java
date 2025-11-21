package com.todoapp.todo.controller;

import com.todoapp.todo.domain.dto.AuthorDto;
import com.todoapp.todo.domain.dto.LoginRequest;
import com.todoapp.todo.domain.dto.RegisterDto;
import com.todoapp.todo.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<AuthorDto> login(@Valid @RequestBody LoginRequest loginRequest) {
        AuthorDto authenticate = authenticationService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());
        return ResponseEntity.ok(authenticate);
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@Valid @RequestBody RegisterDto registerDto) {
        authenticationService.RegisterUser(registerDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
