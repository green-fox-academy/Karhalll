package com.greenfoxacademy.listingtodoswithh2;

import com.greenfoxacademy.listingtodoswithh2.models.Todo;
import com.greenfoxacademy.listingtodoswithh2.repositories.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ListingtodosWithH2Application implements CommandLineRunner {

  private final TodoRepository todoRepository;

  public ListingtodosWithH2Application(
      TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  public static void main(String[] args) {
    SpringApplication.run(ListingtodosWithH2Application.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    todoRepository.save(new Todo("I have to learn Object Relational Mapping"));
    todoRepository.save(new Todo("Throw keys to Gonki"));
    todoRepository.save(new Todo("Walk a dog"));
    todoRepository.save(new Todo("Buy milk"));
    todoRepository.save(new Todo("Learn SQL with Spring framework"));
  }
}
