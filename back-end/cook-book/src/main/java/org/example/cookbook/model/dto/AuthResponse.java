package org.example.cookbook.model.dto;

import org.springframework.http.HttpStatus;

public record AuthResponse(String message, HttpStatus status) {
}
