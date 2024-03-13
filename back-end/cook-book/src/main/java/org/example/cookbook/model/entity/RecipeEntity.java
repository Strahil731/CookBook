package org.example.cookbook.model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "recipes")
public class RecipeEntity extends BaseEntity {
    @Column
    private String title;

    @Column
    private String preparation;

    @Column
    private String imageUrl;

    @OneToMany(fetch = FetchType.EAGER, targetEntity = IngredientEntity.class)
    private List<IngredientEntity> ingredients;

    public RecipeEntity() {

    }

    public String getTitle() {
        return title;
    }

    public RecipeEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getPreparation() {
        return preparation;
    }

    public RecipeEntity setPreparation(String preparation) {
        this.preparation = preparation;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public RecipeEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public List<IngredientEntity> getIngredients() {
        return ingredients;
    }

    public RecipeEntity setIngredients(List<IngredientEntity> ingredients) {
        this.ingredients = ingredients;
        return this;
    }
}
