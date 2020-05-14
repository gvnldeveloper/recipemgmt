package com.receipe.management.controller;

import com.receipe.management.constants.RecipeConstants;
import com.receipe.management.dto.RecipeDto;
import com.receipe.management.exception.ApiResponse;
import com.receipe.management.service.RecipeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operation/")
@RequiredArgsConstructor
@Slf4j
@Validated
public class RecipeController {


    private final RecipeService recipeService;

    @PostMapping(RecipeConstants.SAVE_RECIPE)
    public ResponseEntity<RecipeDto> save(@RequestBody RecipeDto recipeDto) {
        log.info("Inside Save Recipe {}", recipeDto);
        return ResponseEntity.ok(recipeService.save(recipeDto));


    }

    @GetMapping(RecipeConstants.GET_RECIPE)
    public ResponseEntity<RecipeDto> getById(@RequestParam Long recipeId) {
        log.info("Inside Get Recipe by ID {}", recipeId);
        return ResponseEntity.ok(recipeService.getById(recipeId));
    }

    @GetMapping(RecipeConstants.GET_ALL_RECIPE)
    public ResponseEntity<List<RecipeDto>> getAll() {
        log.info("Inside Get All Recipe");
        return ResponseEntity.ok(recipeService.getAll());
    }

    @DeleteMapping(RecipeConstants.DELETE_RECIPE)
    public ResponseEntity<ApiResponse> delete(@RequestParam Long recipeId) {
        log.info("Delete Recipe with ID {} ", recipeId);
        return ResponseEntity.ok(recipeService.delete(recipeId));
    }

    @PostMapping(RecipeConstants.UPDATE_RECIPE)
    public ResponseEntity<RecipeDto> update(@RequestParam Long recipeId, @RequestBody RecipeDto recipeDto) {
        log.info("Update Recipe with ID {} ", recipeId);
        return ResponseEntity.ok(recipeService.update(recipeDto, recipeId));
    }

}
