package org.example.cookbook.web.rest;

import lombok.RequiredArgsConstructor;
import org.example.cookbook.model.dto.recipe.RecipeCreateForm;
import org.example.cookbook.model.dto.recipe.RecipeDto;
import org.example.cookbook.service.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipe")
@RequiredArgsConstructor
public class RecipeController {
    private final RecipeService recipeService;

    @PostMapping("/create")
    public ResponseEntity<RecipeDto> createRecipe(@RequestBody RecipeCreateForm recipeCreateForm) {
        RecipeDto recipe = this.recipeService.createRecipe(recipeCreateForm);

        this.recipeService.refreshRecipes();

        return new ResponseEntity<>(recipe, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<RecipeDto>> getAllRecipes() {
        return new ResponseEntity<>(this.recipeService.getAllRecipes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeDto> getRecipeById(@PathVariable(name = "id") Long id) {
        RecipeDto recipe = this.recipeService.getRecipeById(id);

        if (recipe == null) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(recipe, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RecipeDto> updateRecipe(@RequestBody RecipeCreateForm updatedRecipe, @PathVariable(name = "id") Long id) {
        RecipeDto recipe = this.recipeService.updateRecipe(updatedRecipe, id);

        this.recipeService.refreshRecipes();

        return new ResponseEntity<>(recipe, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RecipeDto> deleteRecipeById(@PathVariable(name = "id") Long id) {
        this.recipeService.deleteRecipeById(id);

        this.recipeService.refreshRecipes();

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<RecipeDto>> searchRecipe(@RequestParam(name = "title") String title) {
        List<RecipeDto> recipes = this.recipeService.searchRecipes(title);
        HttpStatus status = recipes.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK;

        return new ResponseEntity<>(recipes, status);
    }
}
