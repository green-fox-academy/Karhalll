package com.greenfoxacademy.connectionwithmysql.repositories;

import com.greenfoxacademy.connectionwithmysql.models.Todo;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

  List<Todo> findAllByTitleContainsIgnoreCase(String first);
  List<Todo> findAllByContentContainsIgnoreCase(String first);
  List<Todo> findAllByDescriptionContainsIgnoreCase(String first);
  List<Todo> findAllByAssigneeNameContainsIgnoreCase(String name);
  List<Todo> findAllByCreationDate(Date date);
  List<Todo> findAllByDueDate(Date date);
}
