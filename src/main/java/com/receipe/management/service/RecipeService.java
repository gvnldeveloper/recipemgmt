package com.receipe.management.service;

import com.receipe.management.dto.RecipeDto;
import com.receipe.management.exception.ApiResponse;

import java.util.List;

public interface RecipeService {

    RecipeDto save(RecipeDto recipeDto);

    List<RecipeDto> getAll();

    RecipeDto getById(Long recipeId);

    RecipeDto update(RecipeDto recipeDto , Long recipeId);

    ApiResponse delete(Long recipeId);
}
