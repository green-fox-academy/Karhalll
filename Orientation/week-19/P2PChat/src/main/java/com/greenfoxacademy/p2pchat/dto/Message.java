package com.greenfoxacademy.p2pchat.dto;

import java.util.Date;

public class Message {

  private String content;
  private Date created;
  private User author;

  public Message() {
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public User getAuthor() {
    return author;
  }

  public void setAuthor(User author) {
    this.author = author;
  }
}
