package com.greenfoxacademy.basicwebshop.repositories;

import com.greenfoxacademy.basicwebshop.models.ShopItem;
import com.greenfoxacademy.basicwebshop.models.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Stock {

  private List<ShopItem> items;

  public Stock() {
    items = new ArrayList<>();
    items.add(new ShopItem("Running shoes", Type.CS, "Nike running shoes for every day sport", 1000f, 5));
    items.add(new ShopItem("Printer", Type.E, "Some HP printer that will print pages", 3000f, 2));
    items.add(new ShopItem("Coca cola", Type.BS, "0.5l standard coke", 25f, 0));
    items.add(new ShopItem("Wokin", Type.BS, "Chicken with fried rice and WOKIN sauce", 119f, 100));
    items.add(new ShopItem("T-shirt", Type.CS, "Blue with a corgi on a bike", 300f, 1));
  }

  public List<ShopItem> getItems() {
    return items;
  }

  public void setItems(List<ShopItem> items) {
    this.items = items;
  }

  public List<ShopItem> getAvailable() {
    return items.stream()
        .filter(i -> i.getQuantity() > 0)
        .collect(Collectors.toList());
  }

  public List<ShopItem> getSortedByPrice() {
    return items.stream()
        .sorted(Comparator.comparing(ShopItem::getPrice))
        .collect(Collectors.toList());
  }

  public List<ShopItem> getByContains(String string) {
    return items.stream()
        .filter(i -> i.getName().toLowerCase().contains(string.toLowerCase())
            || i.getDescription().toLowerCase().contains(string.toLowerCase()))
        .collect(Collectors.toList());
  }

  public Double averageStock() {
    return items.stream()
        .collect(Collectors.averagingDouble(ShopItem::getQuantity));
  }

  public List<ShopItem> getMostExpensive() {
    return items.stream()
        .max(Comparator.comparing(ShopItem::getPrice))
        .stream().collect(Collectors.toList());
  }
}
