package org.example.cookbook.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ingredients")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientEntity extends BaseEntity {
    @Column
    private String name;

    @Column
    private String quantity;

    @OneToOne(fetch = FetchType.EAGER, targetEntity = RecipeEntity.class)
    private RecipeEntity recipeId;


}
