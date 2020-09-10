package com.greenfox.programmingfoxclub.repositary;

import com.greenfox.programmingfoxclub.model.Fox;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MySqlFoxRepo extends JpaRepository<Fox, Long> {
}
