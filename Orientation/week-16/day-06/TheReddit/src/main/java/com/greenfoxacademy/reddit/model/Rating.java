package com.greenfoxacademy.reddit.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Rating {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Min(-1)
  @Max(1)
  private int rating;

  @ManyToOne(cascade = CascadeType.PERSIST)
  private Post post;
  @ManyToOne(cascade = CascadeType.PERSIST)
  private User user;

  public Rating() {
  }

  public Rating(
      @Min(-1) @Max(1) int rating, Post post, User user) {
    this.rating = rating;
    this.post = post;
    this.user = user;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }

  public Post getPost() {
    return post;
  }

  public void setPost(Post post) {
    this.post = post;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
