package org.example.cookbook.model.dto;

import org.springframework.http.HttpStatus;

public record RegisterResponse(String message, HttpStatus status) {
}
