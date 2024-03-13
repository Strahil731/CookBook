package org.example.cookbook.model.dto.recipe;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cookbook.model.dto.ingredient.IngredientDto;

import java.util.List;

@Data
@NoArgsConstructor
public class RecipeDto {
    private Long id;

    private String title;

    private String preparation;

    private String imageUrl;

    private List<IngredientDto> ingredients;
}
