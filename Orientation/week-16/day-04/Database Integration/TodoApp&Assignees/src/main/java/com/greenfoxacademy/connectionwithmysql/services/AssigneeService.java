package com.greenfoxacademy.connectionwithmysql.services;

import com.greenfoxacademy.connectionwithmysql.models.Assignee;
import com.greenfoxacademy.connectionwithmysql.models.Todo;
import java.util.List;

public interface AssigneeService {
  List<Assignee> listAll();
  Assignee getById(long id);
  void add(Assignee assignee);
  void editById(Assignee assignee);
  void deleteById(long id);

  List<Todo> getTodosById(int id);
}
