package com.receipe.management.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Data
public class RecipeNotFound extends RuntimeException {

    private String message;
    private HttpStatus status;


}
