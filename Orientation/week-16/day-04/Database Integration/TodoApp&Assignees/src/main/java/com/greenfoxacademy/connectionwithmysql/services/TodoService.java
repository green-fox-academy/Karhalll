package com.greenfoxacademy.connectionwithmysql.services;

import com.greenfoxacademy.connectionwithmysql.models.Todo;
import java.util.List;

public interface TodoService {

  Todo getById(long id);
  List<Todo> listAll();
  List<Todo> listByDone(Boolean state);
  List<Todo> listAllBy(String searchTerm, String searchBy);
  void add(Todo todo);
  void edit(Todo todo);
  void deleteById(long id);
}
