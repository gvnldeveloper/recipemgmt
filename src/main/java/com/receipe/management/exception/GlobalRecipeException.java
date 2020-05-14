package com.receipe.management.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalRecipeException {

    @ExceptionHandler({RecipeNotFound.class})
    public final ResponseEntity<ApiResponse> handleException(Exception ex) {
        log.info("Inside Global Exception Handling");
        if (ex instanceof RecipeNotFound) {
            return handleRecipeNotFound(ex);
        } else {
            HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity<>(new ApiResponse("Internal Server Error"), status);
        }
    }

    private ResponseEntity<ApiResponse> handleRecipeNotFound(Exception ex) {
        RecipeNotFound recipeNotFound = (RecipeNotFound) ex;
        log.info("Inside Recipe Not Found Exception Handling");
        return new ResponseEntity<>(new ApiResponse(recipeNotFound.getMessage()), recipeNotFound.getStatus());
    }
}
