package com.greenfoxacademy.connectionwithmysql.services;

import com.greenfoxacademy.connectionwithmysql.models.Todo;
import java.util.List;

public interface TodoService {

  Todo getById(long id);
  List<Todo> listAll();
  List<Todo> listByDone(Boolean state);
  void add(Todo todo);
  void editById(Todo todo);
  void deleteById(long id);
}
