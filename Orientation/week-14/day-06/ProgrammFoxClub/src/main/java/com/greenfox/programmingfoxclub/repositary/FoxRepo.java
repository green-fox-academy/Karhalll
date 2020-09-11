package com.greenfox.programmingfoxclub.repositary;

import com.greenfox.programmingfoxclub.model.Fox;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoxRepo extends JpaRepository<Fox, Long> {
  Fox getFoxByName(String name);
}
