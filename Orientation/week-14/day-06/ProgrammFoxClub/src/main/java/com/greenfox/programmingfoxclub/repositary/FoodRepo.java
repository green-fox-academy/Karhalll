package com.greenfox.programmingfoxclub.repositary;

import com.greenfox.programmingfoxclub.model.nutrient.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepo extends JpaRepository<Food, Long> {
}
