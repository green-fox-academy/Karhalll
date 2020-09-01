package com.greenfox.programmingfoxclub.model.history;

import com.greenfox.programmingfoxclub.model.Nutrient;

public class NutrientAction extends HistoryAction {
  public NutrientAction(Nutrient oldNutrient, Nutrient newNutrient) {
    super(oldNutrient.getClass().getSimpleName() + " has been changed from: "
        + oldNutrient + " to: " + newNutrient);
  }
}
