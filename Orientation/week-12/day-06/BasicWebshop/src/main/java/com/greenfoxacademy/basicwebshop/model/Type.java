package com.greenfoxacademy.basicwebshop.model;

public enum Type {
  BS("Beverages and Snacks"),
  CS("Clothes and Shoes"),
  E("Electronics");

  public final String label;

  private Type(String label) {
    this.label = label;
  }
}
