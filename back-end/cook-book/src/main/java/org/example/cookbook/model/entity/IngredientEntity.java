package org.example.cookbook.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "ingredients")
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
public class IngredientEntity extends BaseEntity {
    @Column
    private String name;

    @Column
    private String quantity;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = RecipeEntity.class)
    @JoinColumn(name = "recipe_id")
    private RecipeEntity recipeId;
}
