package com.greenfoxacademy.basicwebshop.model;

public class ShopItem {
  private String name;
  private String description;
  private Float price;
  private Integer quantity;
  private Type type;

  public ShopItem(String name, Type type, String description, Float price, Integer quantity) {
    this.name = name;
    this.type = type;
    this.description = description;
    this.price = price;
    this.quantity = quantity;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }
}
