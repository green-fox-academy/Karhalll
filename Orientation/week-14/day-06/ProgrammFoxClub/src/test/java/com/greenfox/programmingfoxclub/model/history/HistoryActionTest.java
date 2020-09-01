package com.greenfox.programmingfoxclub.model.history;

import static org.junit.jupiter.api.Assertions.*;

import com.greenfox.programmingfoxclub.model.Drink;
import com.greenfox.programmingfoxclub.model.Food;
import com.greenfox.programmingfoxclub.model.Trick;
import java.time.LocalDateTime;
import java.util.Date;
import org.junit.jupiter.api.Test;

class HistoryActionTest {

  @Test
  void testFoodToString() {
    HistoryAction historyAction = new NutrientAction(Food.chicken, Food.honey);
    assertEquals(historyAction.getDate() + " : " + "Food has been changed from: chicken to: honey", historyAction.toString());
  }

  @Test
  void testDrinkToString() {
    HistoryAction historyAction = new NutrientAction(Drink.beer, Drink.rum);
    assertEquals(historyAction.getDate() + " : " + "Drink has been changed from: beer to: rum", historyAction.toString());
  }

  @Test
  void testActionToString() {
    HistoryAction historyAction = new TrickAction(Trick.Kick);
    assertEquals(historyAction.getDate() + " : " + "Learned to: Kick", historyAction.toString());
  }
}