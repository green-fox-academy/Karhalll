package com.greenfoxacademy.connectionwithmysql.controllers;

import com.greenfoxacademy.connectionwithmysql.models.Todo;
import com.greenfoxacademy.connectionwithmysql.services.AssigneeService;
import com.greenfoxacademy.connectionwithmysql.services.TodoService;
import java.text.ParseException;
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

  private final TodoService todoService;
  private final AssigneeService assigneeService;

  public TodoController(TodoService todoService, AssigneeService assigneeService) {
    this.todoService = todoService;
    this.assigneeService = assigneeService;
  }

  @GetMapping({"", "/", "/list"})
  public String list(@RequestParam(required = false) Boolean isActive, Model model) {
    List<Todo> todos;
    if (isActive == null) {
      todos = todoService.listAll();
    } else {
      todos = todoService.listByDone(!isActive);
    }
    model.addAttribute("todos", todos);
    return "todo-list";
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
    model.addAttribute("assignees", assigneeService.listAll());
    return "edit";
  }

  @PostMapping("/edit")
  public String editTodoById(@ModelAttribute Todo todo) {
    todoService.edit(todo);
    return "redirect:/todo/list";
  }

  @PostMapping("/search")
  public String searchBy(@RequestParam(name = "search_term", required = false) String searchTerm,
                         @RequestParam(name = "search_date", required = false) String date,
                         @RequestParam("search_by") String searchBy,
                         Model model) throws ParseException {
    if (searchTerm != null) {
      model.addAttribute("todos", todoService.listAllBy(searchTerm, searchBy));
    } else if (date != null) {
      model.addAttribute("todos", todoService.listAllByDate(date, searchBy));
    }
    return "todo-list";
  }
}
