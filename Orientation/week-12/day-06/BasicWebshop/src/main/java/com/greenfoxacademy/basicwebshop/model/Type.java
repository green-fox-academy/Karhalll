package com.greenfoxacademy.basicwebshop.model;

public enum Type {
  CS("Clothes and Shoes"),
  E("Electronics"),
  BS("Beverages and Snacks");

  public final String label;

  private Type(String label) {
    this.label = label;
  }
}
