package com.greenfoxacademy.connectionwithmysql.services;

import com.greenfoxacademy.connectionwithmysql.models.Todo;
import com.greenfoxacademy.connectionwithmysql.repositories.TodoRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {

  private final TodoRepository todoRepository;

  public TodoServiceImpl(
      TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  @Override
  public Todo getById(long id) {
    return todoRepository.findById(id).get();
  }

  @Override
  public List<Todo> listAll() {
    return todoRepository.findAll();
  }

  @Override
  public List<Todo> listByDone(Boolean state) {
    return todoRepository.findAll().stream()
        .filter(todo -> todo.isDone() == state)
        .collect(Collectors.toList());
  }

  @Override
  public void add(Todo todo) {
    todoRepository.save(todo);
  }

  @Override
  public void editById(Todo todo) {
    todoRepository.save(todo);
  }

  @Override
  public void deleteById(long id) {
    todoRepository.delete(getById(id));
  }
}
