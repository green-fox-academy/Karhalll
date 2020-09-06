package com.greenfoxacademy.connectionwithmysql.models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "assignees")
public class Assignee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String name;
  private String email;

  @OneToMany
  private List<Todo> todos;

  public void setId(long id) {
    this.id = id;
  }


  public long getId() {
    return id;
  }
}
