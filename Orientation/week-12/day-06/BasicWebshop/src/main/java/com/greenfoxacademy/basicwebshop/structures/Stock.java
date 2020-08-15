package com.greenfoxacademy.basicwebshop.structures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Stock {

  private List<ShopItem> items;

  public Stock() {
    items = new ArrayList<>();
    items.add(new ShopItem("Running shoes", "Nike running shoes for every day sport", 1000f, 5));
    items.add(new ShopItem("Printer", "Some HP printer that will print pages", 3000f, 2));
    items.add(new ShopItem("Coca cola", "0.5l standard coke", 25f, 0));
    items.add(new ShopItem("Wokin", "Chicken with fried rice and WOKIN sauce", 119f, 100));
    items.add(new ShopItem("T-shirt", "Blue with a corgi on a bike", 300f, 1));
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
}
