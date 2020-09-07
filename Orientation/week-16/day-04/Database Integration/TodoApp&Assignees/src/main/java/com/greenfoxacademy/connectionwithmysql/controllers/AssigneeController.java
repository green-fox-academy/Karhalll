package com.greenfoxacademy.connectionwithmysql.controllers;

import com.greenfoxacademy.connectionwithmysql.models.Assignee;
import com.greenfoxacademy.connectionwithmysql.services.AssigneeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/assignee")
public class AssigneeController {

  private final AssigneeService assigneeService;

  public AssigneeController(AssigneeService assigneeService) {
    this.assigneeService = assigneeService;
  }

  @GetMapping({"", "/", "/list"})
  public String list(Model model) {
    model.addAttribute("assignees", assigneeService.listAll());
    return "assignees-list";
  }

  @GetMapping("/add")
  public String addPage(Model model) {
    model.addAttribute("assignee", new Assignee());
    return "add-assignee";
  }

  @PostMapping("/add")
  public String add(@ModelAttribute Assignee assignee) {
    assigneeService.add(assignee);
    return "redirect:/assignee";
  }

  @GetMapping("/{id}/delete")
  public String deleteTodoById(@PathVariable long id) {
    assigneeService.deleteById(id);
    return "redirect:/assignee/list";
  }

  @GetMapping("/{id}/edit")
  public String editTodoByIdPage(@PathVariable long id, Model model) {
    model.addAttribute("assignee", assigneeService.getById(id));
    return "edit-assignee";
  }

  @PostMapping("/edit")
  public String editTodoById(@ModelAttribute Assignee assignee) {
    assigneeService.editById(assignee);
    return "redirect:/assignee/list";
  }
}
