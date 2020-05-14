package com.receipe.management.mapper;

import com.receipe.management.domain.Recipe;
import com.receipe.management.dto.RecipeDto;
import com.receipe.management.exception.RecipeNotFound;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class RecipeMapper {
    public Recipe mapExternalToInternal(RecipeDto recipeDto) {
        Recipe recipe = new Recipe();
        recipe.setCookingInstructions(recipeDto.getCookingInstructions());
        recipe.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        recipe.setIngredients(recipeDto.getIngredients());
        recipe.setName(recipeDto.getName());
        recipe.setNoOfPersons(recipeDto.getNoOfPersons());
        recipe.setVegetarian(recipeDto.isVegetarian());
        return recipe;
    }

    public RecipeDto mapInternalToExternal(Recipe recipe) throws RecipeNotFound {
        RecipeDto recipeDto = new RecipeDto();
        recipeDto.setCookingInstructions(recipe.getCookingInstructions());
        recipeDto.setCreatedDate(recipe.getCreatedDate());
        recipeDto.setIngredients(recipe.getIngredients());
        recipeDto.setName(recipe.getName());
        recipeDto.setNoOfPersons(recipe.getNoOfPersons());
        recipeDto.setVegetarian(recipe.isVegetarian());
        return recipeDto;
    }

    public Recipe updateRecipe(RecipeDto recipeDto, Recipe recipe) throws RecipeNotFound {
        recipe.setCookingInstructions(recipeDto.getCookingInstructions());
        recipe.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        recipe.setIngredients(recipeDto.getIngredients());
        recipe.setName(recipeDto.getName());
        recipe.setNoOfPersons(recipeDto.getNoOfPersons());
        recipe.setVegetarian(recipeDto.isVegetarian());
        return recipe;
    }
}
