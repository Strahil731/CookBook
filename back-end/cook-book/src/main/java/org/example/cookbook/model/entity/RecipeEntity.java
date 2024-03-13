package org.example.cookbook.model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "recipes")
@Data
@Builder
public class RecipeEntity extends BaseEntity {
    @Column
    private String title;

    @Column
    private String preparation;

    @Column
    private String imageUrl;

    @OneToMany(fetch = FetchType.EAGER)
    private List<IngredientEntity> ingredients;

    public RecipeEntity() {

    }
}
