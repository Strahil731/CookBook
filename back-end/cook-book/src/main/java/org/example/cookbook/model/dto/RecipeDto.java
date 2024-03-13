package org.example.cookbook.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

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
