package com.receipe.management.dto;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class RecipeDto {
    private String name;
    private Timestamp createdDate;
    private boolean isVegetarian;
    private int noOfPersons;
    private String[] cookingInstructions;
    private String[] ingredients;
}
