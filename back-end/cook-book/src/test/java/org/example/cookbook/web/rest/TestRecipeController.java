package org.example.cookbook.web.rest;

import org.example.cookbook.model.dto.recipe.RecipeDto;
import org.example.cookbook.service.RecipeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.CoreMatchers.is;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

import static org.mockito.Mockito.when;

@AutoConfigureMockMvc
@SpringBootTest
public class TestRecipeController {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecipeService recipeService;

    @Test
    public void testGettingAllRecipes() throws Exception {
        when(recipeService.getAllRecipes()).thenReturn(createRecipes());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/recipe/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].id", is(1)))
                .andExpect(jsonPath("$.[0].title", is("Pizza")))
                .andExpect(jsonPath("$.[0].imageUrl", is("url1")))
                .andExpect(jsonPath("$.[1].id", is(2)))
                .andExpect(jsonPath("$.[1].title", is("Lasagna")))
                .andExpect(jsonPath("$.[1].imageUrl", is("url2")));

    }

    private List<RecipeDto> createRecipes() {
        RecipeDto recipe1 = new RecipeDto(1L, "Pizza", "cook", "url1", null, 1L);
        RecipeDto recipe2 = new RecipeDto(2L, "Lasagna", "cook", "url2", null, 2L);

        return List.of(recipe1, recipe2);
    }
}
