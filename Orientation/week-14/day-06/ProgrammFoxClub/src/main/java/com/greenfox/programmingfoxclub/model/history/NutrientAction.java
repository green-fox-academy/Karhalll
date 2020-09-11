package com.greenfox.programmingfoxclub.model.history;

import com.greenfox.programmingfoxclub.model.nutrient.Nutrient;
import javax.persistence.Entity;

@Entity
public class NutrientAction extends HistoryAction {
  public NutrientAction(Nutrient oldNutrient, Nutrient newNutrient) {
    super(oldNutrient.getClass().getSimpleName() + " has been changed from: "
        + oldNutrient.getName() + " to: " + newNutrient.getName());
  }

  public NutrientAction() {

  }
}
