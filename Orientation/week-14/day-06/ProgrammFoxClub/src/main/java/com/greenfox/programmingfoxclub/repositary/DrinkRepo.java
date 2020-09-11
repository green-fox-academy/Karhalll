package com.greenfox.programmingfoxclub.repositary;

import com.greenfox.programmingfoxclub.model.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrinkRepo extends JpaRepository<Drink, Long> {
}
