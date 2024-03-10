package org.example.cookbook.service;

import lombok.RequiredArgsConstructor;
import org.example.cookbook.exception.UserAlreadyExistsException;
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

    public String registerUser(RegisterForm registerForm) {
        if (this.userRepository.findUserByEmail(registerForm.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("User with email (" + registerForm.getEmail() + ") already exists!");
        }

        UserEntity user = new UserEntity()
                .setEmail(registerForm.getEmail())
                .setFirstName(registerForm.getFirstName())
                .setLastName(registerForm.getLastName())
                .setPassword(passwordEncoder.encode(registerForm.getPassword()));

        this.userRepository.save(user);

        return "Account successfully created!";
    }
}
