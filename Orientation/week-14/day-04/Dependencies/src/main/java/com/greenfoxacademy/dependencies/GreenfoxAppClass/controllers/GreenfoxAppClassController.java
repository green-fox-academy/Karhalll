package com.greenfoxacademy.dependencies.GreenfoxAppClass.controllers;

import com.greenfoxacademy.dependencies.GreenfoxAppClass.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreenfoxAppClassController {

  private final StudentService studentService;

  public GreenfoxAppClassController(
      StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping("/gfa")
  public String mainPage(Model model) {
    model.addAttribute("usersCount", studentService.count());
    return "gfa/gfa";
  }

  @GetMapping("/gfa/list")
  public String listAllStudents(Model model) {
    model.addAttribute("students", studentService.findAll());
    return "gfa/students-list";
  }

  @GetMapping("/gfa/add")
  public String addStudentPage() {
    return "gfa/add-student";
  }

  @PostMapping("/gfa/save")
  public String addStudent(@RequestParam String studentName) {
    studentService.save(studentName);
    return "redirect:/gfa";
  }

  @GetMapping("/gfa/check")
  public String check() {
    return "gfa/check-student";
  }

  @PostMapping("/gfa/check")
  public String checkStudent(@RequestParam(required = false) String studentName, Model model) {
    model.addAttribute("studentName", studentName);
    model.addAttribute("isStudent", studentService.isStudent(studentName));
    return "gfa/check-student";
  }
}
