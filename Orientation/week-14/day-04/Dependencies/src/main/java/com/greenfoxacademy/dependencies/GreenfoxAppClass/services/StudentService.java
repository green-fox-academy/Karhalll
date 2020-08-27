package com.greenfoxacademy.dependencies.GreenfoxAppClass.services;

import java.util.List;

public interface StudentService {

  public List<String> findAll();

  public void save(String student);

  public int count();

  public boolean isStudent(String name);
}
