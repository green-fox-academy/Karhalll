package com.greenfoxacademy.connectionwithmysql.controllers;

import com.greenfoxacademy.connectionwithmysql.models.Todo;
import com.greenfoxacademy.connectionwithmysql.repositories.TodoRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/todo")
public class TodoController {

  private final TodoRepository todoRepository;

  public TodoController(
      TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  @GetMapping({"/", "/list"})
  public String list(@RequestParam(required = false) Boolean isActive, Model model) {
    List<Todo> todos;
    if (isActive == null) {
      todos = todoRepository.findAll();
    } else {
      todos = todoRepository.findAll().stream()
          .filter(todo -> !todo.isDone() == isActive)
          .collect(Collectors.toList());
      System.out.println("isActive");
    }
    model.addAttribute("todos", todos);
    return "todolist";
  }
}
