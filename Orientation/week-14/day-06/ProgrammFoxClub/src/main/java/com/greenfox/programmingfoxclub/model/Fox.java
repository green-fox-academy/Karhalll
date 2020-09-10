package com.greenfox.programmingfoxclub.model;

import com.greenfox.programmingfoxclub.model.history.HistoryLog;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Fox {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String name;

  @ManyToMany
  private List<Trick> tricks;
  private Food food;
  private Drink drink;
  @OneToOne
  private HistoryLog changeLog;

  public Fox() {}

  public Fox(String name) {
    this(name, new ArrayList<>(), Food.chicken, Drink.water);
  }

  private Fox(String name, List<Trick> tricks, Food food, Drink drink) {
    this.name = name;
    this.tricks = tricks;
    this.food = food;
    this.drink = drink;
    this.changeLog = new HistoryLog();
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
    changeLog.logNutritionChange(this.food, food);
    this.food = food;
  }

  public Drink getDrink() {
    return drink;
  }

  public void setDrink(Drink drink) {
    changeLog.logNutritionChange(this.drink, drink);
    this.drink = drink;
  }

  public HistoryLog getChangeLog() {
    return changeLog;
  }

  public void setChangeLog(HistoryLog changeLog) {
    this.changeLog = changeLog;
  }

  public void addTrick(Trick trick) {
    if (isNotLearned(trick)) {
      changeLog.logLearnedTrick(trick);
      tricks.add(trick);
    }
  }

  private boolean isNotLearned(Trick trick) {
    return tricks.stream()
        .noneMatch(t -> t.equals(trick));
  }
}
