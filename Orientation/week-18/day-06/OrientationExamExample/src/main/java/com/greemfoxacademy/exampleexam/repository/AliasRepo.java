package com.greemfoxacademy.exampleexam.repository;

import com.greemfoxacademy.exampleexam.model.Alias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AliasRepo  extends JpaRepository<Alias, Integer> {
  Alias findFirstByAlias(String alias);
}
