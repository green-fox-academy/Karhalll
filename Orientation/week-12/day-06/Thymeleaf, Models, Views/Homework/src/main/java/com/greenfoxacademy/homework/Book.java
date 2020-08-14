package com.greenfoxacademy.homework;

public class Book {
  private int id;
  private String title;
  private String author;
  private Integer releaseYear;

  private static int nextId = 0;

  public Book() {
  }

  public Book(String title, String author, Integer releaseYear) {
    setNextId();
    this.title = title;
    this.author = author;
    this.releaseYear = releaseYear;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Integer getReleaseYear() {
    return releaseYear;
  }

  public void setReleaseYear(Integer releaseYear) {
    this.releaseYear = releaseYear;
  }

  public void setNextId() {
    id = nextId++;
  }
}
