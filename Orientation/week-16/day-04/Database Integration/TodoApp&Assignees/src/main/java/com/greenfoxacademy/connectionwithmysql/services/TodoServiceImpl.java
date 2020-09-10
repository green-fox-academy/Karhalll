package com.greenfoxacademy.connectionwithmysql.services;

import com.greenfoxacademy.connectionwithmysql.models.Todo;
import com.greenfoxacademy.connectionwithmysql.repositories.TodoRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
  public List<Todo> listAllBy(String searchTerm, String searchBy) {
    return switch (searchBy) {
      case "Title" -> todoRepository.findAllByTitleContainsIgnoreCase(searchTerm);
      case "Content" -> todoRepository.findAllByContentContainsIgnoreCase(searchTerm);
      case "Description" -> todoRepository.findAllByDescriptionContainsIgnoreCase(searchTerm);
      case "Assignee's name" -> todoRepository.findAllByAssigneeNameContainsIgnoreCase(searchTerm);
      default -> null;
    };
  }

  @Override
  public List<Todo> listAllByDate(String dateToSearch, String searchBy) throws ParseException {
    return switch (searchBy) {
      case "Create Date" -> todoRepository.findAllByCreationDate(new SimpleDateFormat("yyyy-MM-dd").parse(dateToSearch));
      case "Due Date" -> todoRepository.findAllByDueDate(new SimpleDateFormat("yyyy-MM-dd").parse(dateToSearch));
      default -> null;
    };
  }

  @Override
  public void add(Todo todo) {
    todo.setCreationDate(new Date());
    todoRepository.save(todo);
  }

  @Override
  public void edit(Todo todo) {
    Todo oldTodo = getById(todo.getId());
    todo.setCreationDate(oldTodo.getCreationDate());
    todoRepository.save(todo);
  }

  @Override
  public void deleteById(long id) {
    todoRepository.delete(getById(id));
  }
}
