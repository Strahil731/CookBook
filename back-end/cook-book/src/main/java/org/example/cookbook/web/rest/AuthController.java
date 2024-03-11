package org.example.cookbook.web.rest;

import lombok.RequiredArgsConstructor;
import org.example.cookbook.model.dto.LoginForm;
import org.example.cookbook.model.dto.AuthResponse;
import org.example.cookbook.model.dto.RegisterForm;
import org.example.cookbook.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterForm registerForm) {
        AuthResponse response = this.userService.registerUser(registerForm);

        return new ResponseEntity<>(response.message(), response.status());
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginForm loginForm){
        AuthResponse response = this.userService.login(loginForm);

        return new ResponseEntity<>(response.message(), response.status());
    }
}
