package com.greenfoxacademy.connectionwithmysql.services;

import com.greenfoxacademy.connectionwithmysql.models.Assignee;
import java.util.List;

public interface AssigneeService {
  List<Assignee> listAll();
  void add(Assignee assignee);
}
