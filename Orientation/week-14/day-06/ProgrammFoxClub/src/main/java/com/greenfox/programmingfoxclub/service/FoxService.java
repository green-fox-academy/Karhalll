package com.greenfox.programmingfoxclub.service;

import com.greenfox.programmingfoxclub.model.Drink;
import com.greenfox.programmingfoxclub.model.Food;
import com.greenfox.programmingfoxclub.model.Fox;
import com.greenfox.programmingfoxclub.model.Trick;
import com.greenfox.programmingfoxclub.repositary.DrinkRepo;
import com.greenfox.programmingfoxclub.repositary.FoodRepo;
import com.greenfox.programmingfoxclub.repositary.FoxRepo;
import com.greenfox.programmingfoxclub.repositary.TrickRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoxService {

  FoxRepo foxRepo;

  TrickRepo trickRepo;
  FoodRepo foodRepo;
  DrinkRepo drinkRepo;

  public FoxService(FoxRepo foxRepo, TrickRepo trickRepo, FoodRepo foodRepo,
                    DrinkRepo drinkRepo) {
    this.foxRepo = foxRepo;
    this.trickRepo = trickRepo;
    this.foodRepo = foodRepo;
    this.drinkRepo = drinkRepo;
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
    foxToEdit.setFood(food);
    foxToEdit.setDrink(drink);
    foxRepo.save(foxToEdit);
  }

  private void setDefaultNutrients(Fox fox) {
    fox.setDrink(drinkRepo.findAll().get(0));
    fox.setFood(foodRepo.findAll().get(0));
  }
}
