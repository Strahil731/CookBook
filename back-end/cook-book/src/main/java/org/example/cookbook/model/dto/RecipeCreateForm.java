package org.example.cookbook.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RecipeCreateForm {
    private String title;

    private String preparation;

    private String imageUrl;

    private String ingredients;
}
