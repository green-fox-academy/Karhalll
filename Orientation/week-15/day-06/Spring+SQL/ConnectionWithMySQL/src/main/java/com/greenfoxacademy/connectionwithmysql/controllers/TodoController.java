package com.greenfoxacademy.connectionwithmysql.controllers;

import com.greenfoxacademy.connectionwithmysql.models.Todo;
import com.greenfoxacademy.connectionwithmysql.services.TodoServiceImpl;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    todoService.add(todo);
    return "redirect:/todo/list";
  }

  @GetMapping("/{id}/delete")
  public String deleteTodoById(@PathVariable long id) {
    todoService.deleteById(id);
    return "redirect:/todo/list";
  }

  @GetMapping("/{id}/edit")
  public String editTodoByIdPage(@PathVariable long id, Model model) {
    model.addAttribute("todo", todoService.getById(id));
    return "edit";
  }

  @PostMapping("/{id}/edit")
  public String editTodoById(@PathVariable long id, @ModelAttribute Todo todo) {
    todoService.editById(id, todo);
    return "redirect:/todo/list";
  }
}
