package com.receipe.management.serviceimpl;

import com.receipe.management.dao.RecipeDao;
import com.receipe.management.domain.Recipe;
import com.receipe.management.dto.RecipeDto;
import com.receipe.management.exception.ApiResponse;
import com.receipe.management.exception.RecipeNotFound;
import com.receipe.management.mapper.RecipeMapper;
import com.receipe.management.service.RecipeService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeDao recipeDao;

    private final RecipeMapper recipeMapper;

    @Override
    public RecipeDto save(RecipeDto recipeDto) {
        return recipeMapper.mapInternalToExternal(recipeDao.save(recipeMapper.mapExternalToInternal(recipeDto)));
    }

    @Override
    public List<RecipeDto> getAll() {
        List<RecipeDto> recipesRet = new ArrayList<>();
        List<Recipe> recipes = recipeDao.findAll();
        recipes.stream().forEach(recipe -> recipesRet.add(recipeMapper.mapInternalToExternal(recipe)));
        if (recipesRet.isEmpty())
            throw new RecipeNotFound("Recipe Not Found", HttpStatus.OK);
        return recipesRet;
    }

    @Override
    public RecipeDto getById(Long recipeId) {
        Optional<Recipe> recipe = recipeDao.findById(recipeId);
        return recipe.map(recipeMapper::mapInternalToExternal).orElseThrow(() -> new RecipeNotFound("Recipe Not Found", HttpStatus.OK));
    }


    @Override
    public ApiResponse delete(Long recipeId) {
        Optional<Recipe> recipe = recipeDao.findById(recipeId);
        if (recipe.isPresent()) {
            recipeDao.deleteById(recipeId);
            return new ApiResponse("Recipe deleted successfully");
        } else
            throw new RecipeNotFound("No Recipe Found for provided ID", HttpStatus.OK);
    }

    @Override
    public RecipeDto update(RecipeDto recipeDto, Long recipeId) {
        Optional<Recipe> recipe = recipeDao.findById(recipeId);
        if (recipe.isPresent()) {
            return recipeMapper.mapInternalToExternal(recipeDao.save(recipeMapper.updateRecipe(recipeDto, recipe.get())));
        } else {
            throw new RecipeNotFound("Recipe Not Found", HttpStatus.OK);
        }
    }
}
