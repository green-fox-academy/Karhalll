package com.greenfox.programmingfoxclub.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "foxes")
public class Fox {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String name;

  @ManyToOne
  @JoinColumn
  private User user;
  @ManyToOne
  @JoinColumn
  private Food food;
  @ManyToOne
  @JoinColumn
  private Drink drink;
  @ManyToMany
  private List<Trick> tricks;
  @OneToMany(mappedBy = "fox", cascade = CascadeType.PERSIST,orphanRemoval = true)
  private List<HistoryAction> historyActions;

  public Fox() {}

  public Fox(String name) {
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

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public List<Trick> getTricks() {
    return tricks;
  }

  public void setTricks(List<Trick> tricks) {
    this.tricks = tricks;
  }

  public Food getFood() {
    return food;
  }

  public void setFood(Food food) {
    this.food = food;
  }

  public Drink getDrink() {
    return drink;
  }

  public void setDrink(Drink drink) {
    this.drink = drink;
  }

  public List<HistoryAction> getHistoryActions() {
    return historyActions;
  }

  public void setHistoryActions(
      List<HistoryAction> historyActions) {
    this.historyActions = historyActions;
  }
}
