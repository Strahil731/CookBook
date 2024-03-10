package org.example.cookbook.service;

import lombok.RequiredArgsConstructor;
import org.example.cookbook.model.dto.RegisterForm;
import org.example.cookbook.model.entity.UserEntity;
import org.example.cookbook.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public String registerUser(RegisterForm registerForm){
        UserEntity user = UserEntity.builder()
                .email(registerForm.getEmail())
                .firstName(registerForm.getFirstName())
                .lastName(registerForm.getLastName())
                .password(passwordEncoder.encode(registerForm.getPassword()))
                .build();

        this.userRepository.save(user);

        return "Account successfully created!";
    }
}
