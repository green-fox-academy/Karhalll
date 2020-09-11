package com.greenfox.programmingfoxclub.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "foods")
public class Food implements Nutrient {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String name;

  @OneToMany(mappedBy = "food", cascade = CascadeType.PERSIST)
  private List<Fox> fox;

  public Food() {}

  public Food(String name) {
    this.name = name;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Fox> getFox() {
    return fox;
  }

  public void setFox(List<Fox> fox) {
    this.fox = fox;
  }
}
