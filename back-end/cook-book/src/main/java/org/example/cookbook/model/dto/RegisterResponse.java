package org.example.cookbook.model.dto;

import org.springframework.http.HttpStatus;

public record RegisterResponse(UserDto message, HttpStatus status) {
}
