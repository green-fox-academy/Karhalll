package com.greenfoxacademy.connectionwithmysql.services;

import com.greenfoxacademy.connectionwithmysql.models.Assignee;
import com.greenfoxacademy.connectionwithmysql.models.Todo;
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

  @Override
  public Assignee getById(long id) {
    return assigneeRepository.findById(id).get();
  }

  @Override
  public void add(Assignee assignee) {
    assigneeRepository.save(assignee);
  }

  @Override
  public void editById(Assignee assignee) {
    assigneeRepository.save(assignee);
  }

  @Override
  public void deleteById(long id) {
    Assignee assigneeToDelete = getById(id);
    assigneeToDelete.getTodos().forEach(todo -> todo.setAssignee(null));
    assigneeRepository.delete(assigneeToDelete);
  }

  @Override
  public List<Todo> getTodosById(int id) {
    return getById(id).getTodos();
  }
}
