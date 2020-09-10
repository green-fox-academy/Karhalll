package com.greenfox.programmingfoxclub.model.history;

import com.greenfox.programmingfoxclub.model.Fox;
import com.greenfox.programmingfoxclub.model.Nutrient;
import com.greenfox.programmingfoxclub.model.Trick;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class HistoryLog {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long Id;

  @OneToOne
  private Fox fox;
  @OneToMany
  private List<HistoryAction> historyActions;

  public HistoryLog() {
    historyActions = new ArrayList<>() {
    };
  }

  public long getId() {
    return Id;
  }

  public void setId(long id) {
    Id = id;
  }



  public void setHistoryActions(
      List<HistoryAction> historyActions) {
    this.historyActions = historyActions;
  }

  public List<HistoryAction> getHistoryActions() {
    List<HistoryAction> list = new ArrayList<>(historyActions);
    Collections.reverse(list);
    return list;
  }

  public List<HistoryAction> getLastNActions(int n) {
    return getHistoryActions().stream()
        .limit(n-1)
        .collect(Collectors.toList());
  }

  public void logNutritionChange(Nutrient oldNutrient, Nutrient newNutrient) {
    if (oldNutrient.equals(newNutrient)) {
      return;
    }

    historyActions.add(new NutrientAction(oldNutrient, newNutrient));
  }

  public void logLearnedTrick(Trick learnedTrick) {
    historyActions.add(new TrickAction(learnedTrick));
  }
}
