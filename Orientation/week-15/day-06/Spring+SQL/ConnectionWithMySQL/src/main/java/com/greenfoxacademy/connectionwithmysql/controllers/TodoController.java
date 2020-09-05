package com.greenfoxacademy.connectionwithmysql.controllers;

import com.greenfoxacademy.connectionwithmysql.models.Todo;
import com.greenfoxacademy.connectionwithmysql.services.TodoServiceImpl;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/todo")
public class TodoController {

  private final TodoServiceImpl todoService;

  public TodoController(TodoServiceImpl todoService) {
    this.todoService = todoService;
  }

  @GetMapping({"/", "/list"})
  public String list(@RequestParam(required = false) Boolean isActive, Model model) {
    List<Todo> todos;
    if (isActive == null) {
      todos = todoService.listAll();
    } else {
      todos = todoService.listByDone(!isActive);
    }
    model.addAttribute("todos", todos);
    return "todolist";
  }

  @GetMapping("/add")
  public String addTodoPage(Model model) {
    model.addAttribute("todo", new Todo());
    return "add";
  }

  @PostMapping("/add")
  public String addTodo(@ModelAttribute Todo todo) {
    todoService.addTodo(todo);
    return "redirect:/todo/list";
  }
}
