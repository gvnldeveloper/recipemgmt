package com.receipe.management.dao;

import com.receipe.management.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeDao extends JpaRepository<Recipe , Long> {
}
