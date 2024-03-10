package org.example.cookbook.service;

import lombok.RequiredArgsConstructor;
import org.example.cookbook.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
}
