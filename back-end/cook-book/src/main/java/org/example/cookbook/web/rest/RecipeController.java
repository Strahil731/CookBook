package org.example.cookbook.web.rest;

import lombok.RequiredArgsConstructor;
import org.example.cookbook.model.dto.RecipeCreateForm;
import org.example.cookbook.model.dto.RecipeDto;
import org.example.cookbook.service.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/recipe")
@RequiredArgsConstructor
public class RecipeController {
    private final RecipeService recipeService;

    @PostMapping("/create")
    public ResponseEntity<RecipeDto> createRecipe(@RequestBody RecipeCreateForm recipeCreateForm) {
        return new ResponseEntity<>(this.recipeService.createRecipe(recipeCreateForm), HttpStatus.CREATED);
    }
}
