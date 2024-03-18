package org.example.cookbook.service;

import lombok.RequiredArgsConstructor;
import org.example.cookbook.model.dto.recipe.RecipeCreateForm;
import org.example.cookbook.model.dto.recipe.RecipeDto;
import org.example.cookbook.model.entity.IngredientEntity;
import org.example.cookbook.model.entity.RecipeEntity;
import org.example.cookbook.model.entity.UserEntity;
import org.example.cookbook.repository.IngredientRepository;
import org.example.cookbook.repository.RecipeRepository;
import org.example.cookbook.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final IngredientRepository ingredientRepository;


    public List<RecipeDto> getAllRecipes() {
        return this.recipeRepository.findAll()
                .stream()
                .map(r -> modelMapper.map(r, RecipeDto.class))
                .toList();
    }

    public RecipeDto createRecipe(RecipeCreateForm recipeCreateForm) {
        UserEntity user = this.userRepository.findById(recipeCreateForm.getUserId())
                .orElseThrow(IllegalArgumentException::new);

        RecipeEntity recipe = new RecipeEntity()
                .setTitle(recipeCreateForm.getTitle())
                .setPreparation(recipeCreateForm.getPreparation())
                .setImageUrl(recipeCreateForm.getImageUrl())
                .setUser(user);

        recipe = this.recipeRepository.save(recipe);

        List<IngredientEntity> ingredients = extractIngredients(recipeCreateForm, recipe);

        this.ingredientRepository.saveAll(ingredients);

        return modelMapper.map(recipe, RecipeDto.class);
    }

    private List<IngredientEntity> extractIngredients(RecipeCreateForm recipeCreateForm, RecipeEntity recipe) {
        String[] arr = recipeCreateForm.getIngredients().split("\\r?\\n");
        List<IngredientEntity> ingredients = new ArrayList<>();

        for (String ingredient : arr) {
            String name = ingredient.split("-")[0];
            String quantity = ingredient.split("-")[1];
            ingredients.add(new IngredientEntity(name, quantity, recipe));
        }

        return ingredients;
    }
}
