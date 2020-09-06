package com.greenfoxacademy.connectionwithmysql.services;

import com.greenfoxacademy.connectionwithmysql.models.Assignee;
import com.greenfoxacademy.connectionwithmysql.repositories.AssigneeRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AssigneeServiceImpl implements AssigneeService {

  private final AssigneeRepository assigneeRepository;

  public AssigneeServiceImpl(
      AssigneeRepository assigneeRepository) {
    this.assigneeRepository = assigneeRepository;
  }

  @Override
  public List<Assignee> listAll() {
    return assigneeRepository.findAll();
  }
}