package com.greenfoxacademy.connectionwithmysql.services;

import com.greenfoxacademy.connectionwithmysql.models.Todo;
import java.util.List;

public interface TodoService {
  List<Todo> listAll();
  List<Todo> listByDone(Boolean state);
}
