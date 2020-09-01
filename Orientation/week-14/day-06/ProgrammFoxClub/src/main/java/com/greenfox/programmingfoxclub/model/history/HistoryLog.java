package com.greenfox.programmingfoxclub.model.history;

import com.greenfox.programmingfoxclub.model.Nutrient;
import com.greenfox.programmingfoxclub.model.Trick;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HistoryLog {

  private List<HistoryAction> historyActions;

  public HistoryLog() {
    historyActions = new ArrayList<>() {
    };
  }

  public List<HistoryAction> getHistoryActions() {
    return historyActions;
  }

  public List<HistoryAction> getLastNActions(int n) {
    return historyActions.stream()
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
