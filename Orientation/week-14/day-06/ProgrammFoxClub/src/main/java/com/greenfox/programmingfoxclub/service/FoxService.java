package com.greenfox.programmingfoxclub.service;

import com.greenfox.programmingfoxclub.model.history.TrickAction;
import com.greenfox.programmingfoxclub.model.nutrient.Drink;
import com.greenfox.programmingfoxclub.model.nutrient.Food;
import com.greenfox.programmingfoxclub.model.Fox;
import com.greenfox.programmingfoxclub.model.history.HistoryAction;
import com.greenfox.programmingfoxclub.model.Trick;
import com.greenfox.programmingfoxclub.model.history.NutrientAction;
import com.greenfox.programmingfoxclub.model.nutrient.Nutrient;
import com.greenfox.programmingfoxclub.repositary.DrinkRepo;
import com.greenfox.programmingfoxclub.repositary.FoodRepo;
import com.greenfox.programmingfoxclub.repositary.FoxRepo;
import com.greenfox.programmingfoxclub.repositary.HistoryActionRepo;
import com.greenfox.programmingfoxclub.repositary.TrickRepo;
import java.util.Comparator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoxService {

  FoxRepo foxRepo;

  TrickRepo trickRepo;
  FoodRepo foodRepo;
  DrinkRepo drinkRepo;
  HistoryActionRepo historyActionRepo;

  public FoxService(FoxRepo foxRepo, TrickRepo trickRepo,
                    FoodRepo foodRepo, DrinkRepo drinkRepo,
                    HistoryActionRepo historyActionRepo) {
    this.foxRepo = foxRepo;
    this.trickRepo = trickRepo;
    this.foodRepo = foodRepo;
    this.drinkRepo = drinkRepo;
    this.historyActionRepo = historyActionRepo;
  }

  public List<Trick> tricksToLearn(String name) {
    if (!isFox(name)) {
      return null;
    }
    return trickRepo.findAll().stream()
        .filter(trick -> getByName(name).getTricks().stream()
            .noneMatch(learnedTrick -> learnedTrick == trick))
        .collect(Collectors.toList());
  }

  public Fox getByName(String foxName) {
    return foxRepo.getFoxByName(foxName);
  }

  public void creatByName(String newFoxName) {
    Fox foxToCreate = new Fox(newFoxName);
    setDefaultNutrients(foxToCreate);
    foxRepo.save(foxToCreate);
  }

  public boolean isFox(String foxName) {
    return getByName(foxName) != null;
  }

  public void learnTrick(String foxName, Trick newTrick) {
    Fox fox = getByName(foxName);
    List<Trick> tricks = fox.getTricks();
    tricks.add(newTrick);
    fox.setTricks(tricks);
    loqTrickAction(fox, newTrick);
    foxRepo.save(fox);
  }

  public List<Drink> getAllAvailableDrinks() {
    return drinkRepo.findAll();
  }

  public List<Food> getAllAvailableFoods() {
    return foodRepo.findAll();
  }

  public void setNutrients(String foxName, Food food, Drink drink) {
    Fox foxToEdit = getByName(foxName);

    logFoodChange(foxToEdit, food);
    logDrinkChange(foxToEdit, drink);

    foxToEdit.setFood(food);
    foxToEdit.setDrink(drink);

    foxRepo.save(foxToEdit);
  }

  public List<HistoryAction> getSortedActionHistory(String foxName) {
    List<HistoryAction> historyActions = getByName(foxName).getHistoryActions();
    historyActions.sort(Comparator.comparing(HistoryAction::getDate).reversed());
    return historyActions;
  }

  public List<HistoryAction> getFirst5SortedActionHistory(String foxName) {
    List<HistoryAction> first5Actions = historyActionRepo.findTop5ByFoxNameOrderByDateDesc(foxName);
    return first5Actions;
  }

  private void setDefaultNutrients(Fox fox) {
    fox.setDrink(drinkRepo.findAll().get(0));
    fox.setFood(foodRepo.findAll().get(0));
  }

  private void logFoodChange(Fox fox, Food newFood) {
    Food oldFood = fox.getFood();
    if (oldFood != newFood) {
      loqNutrientAction(fox, newFood, oldFood);
    }
  }

  private void logDrinkChange(Fox fox, Drink newDrink) {
    Drink oldDrink = fox.getDrink();
    if (oldDrink != newDrink) {
      loqNutrientAction(fox, newDrink, oldDrink);
    }
  }

  private void loqNutrientAction(Fox fox, Nutrient newNutrient, Nutrient oldNutrient) {
    HistoryAction newHistoryAction = new NutrientAction(oldNutrient, newNutrient);
    newHistoryAction.setFox(fox);
    historyActionRepo.save(newHistoryAction);
  }

  private void loqTrickAction(Fox fox, Trick trickToLog) {
    HistoryAction newHistoryAction = new TrickAction(trickToLog);
    newHistoryAction.setFox(fox);
    historyActionRepo.save(newHistoryAction);
  }
}

