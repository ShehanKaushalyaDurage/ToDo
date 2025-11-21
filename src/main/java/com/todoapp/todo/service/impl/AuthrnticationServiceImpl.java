package com.todoapp.todo.service.impl;

import com.todoapp.todo.domain.dto.AuthorDto;
import com.todoapp.todo.domain.dto.RegisterDto;
import com.todoapp.todo.domain.entity.User;
import com.todoapp.todo.repo.UserRepo;
import com.todoapp.todo.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthrnticationServiceImpl implements AuthenticationService {

    private final UserRepo userRepo;

    @Override
    public AuthorDto authenticate(String email, String password) {

        Optional<User> user = userRepo.findByEmail(email);

        if (user.isPresent()) {
            if (user.get().getPassword().equals(password)) {
                return new AuthorDto(user.get().getId(), user.get().getEmail());
            }else {
                throw new IllegalArgumentException("Wrong password");
            }
        }else  {
            throw new IllegalArgumentException("Wrong email");
        }
    }

    @Transactional
    @Override
    public void RegisterUser(RegisterDto registerDto) {

        if (userRepo.findByEmail(registerDto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }else {
            User user = new User();
            user.setName(registerDto.getName());
            user.setEmail(registerDto.getEmail());
            user.setPassword(registerDto.getPassword());
            userRepo.save(user);
        }

    }
}
