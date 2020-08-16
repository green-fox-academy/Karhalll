package com.greenfoxacademy.basicwebshop.models;

public enum Type {
  BS("Beverages and Snacks"),
  CS("Clothes and Shoes"),
  E("Electronics");

  public final String label;

  private Type(String label) {
    this.label = label;
  }
}
