package com.receipe.management.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.Generated;
import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String name;
    private Timestamp createdDate;
    private boolean vegetarian;
    private int noOfPersons;
    @ElementCollection
    @OrderColumn
    private String[] cookingInstructions;

    @ElementCollection
    @OrderColumn
    private String[] ingredients;

}
