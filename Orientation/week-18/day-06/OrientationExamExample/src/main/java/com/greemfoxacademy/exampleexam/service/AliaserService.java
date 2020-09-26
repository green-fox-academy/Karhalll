package com.greemfoxacademy.exampleexam.service;

import com.greemfoxacademy.exampleexam.model.Alias;

public interface AliaserService {
  boolean isAlias(String alias);
  Alias newAliaser(String url, String alias);
  Alias getAliasByAlias(String alias);
}
