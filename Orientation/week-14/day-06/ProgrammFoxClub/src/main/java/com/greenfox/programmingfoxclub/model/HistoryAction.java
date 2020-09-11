package com.greenfox.programmingfoxclub.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "history_actions")
public class HistoryAction {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Temporal(TemporalType.TIMESTAMP)
  private Date date;
  private String action;

  @ManyToOne
  @JoinColumn
  private Fox fox;

  public HistoryAction() {}

  protected HistoryAction(String action) {
    this.date = new Date();
    this.action = action;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Date getDate() {
    return date;
  }

  public String getAction() {
    return action;
  }

  @Override
  public String toString() {
    return "ToDo!!!!!";
  }
}
