package org.example.cookbook.service;

import lombok.RequiredArgsConstructor;
import org.example.cookbook.repository.RecipeRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeRepository recipeRepository;
}
