package com.greenfoxacademy.basicwebshop.models;

public class Search {
  String text;

  public Search() {
  }

  public Search(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
