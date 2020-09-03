package com.greenfox.programmingfoxclub.model.history;

import com.greenfox.programmingfoxclub.model.Nutrient;
import com.greenfox.programmingfoxclub.model.Trick;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HistoryLog {

  private List<HistoryAction> historyActions;

  public HistoryLog() {
    historyActions = new ArrayList<>() {
    };
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
    historyActions.add(new NutrientAction(oldNutrient, newNutrient));
  }

  public void logLearnedTrick(Trick learnedTrick) {
    historyActions.add(new TrickAction(learnedTrick));
  }
}
