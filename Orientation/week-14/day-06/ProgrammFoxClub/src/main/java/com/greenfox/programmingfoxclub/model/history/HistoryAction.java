package com.greenfox.programmingfoxclub.model.history;

import com.greenfox.programmingfoxclub.model.Fox;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
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

  public HistoryAction(String action) {
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

  public void setDate(Date date) {
    this.date = date;
  }

  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public Fox getFox() {
    return fox;
  }

  public void setFox(Fox fox) {
    this.fox = fox;
  }

  @Override
  public String toString() {
    LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

    return
        localDateTime.getYear() + ". "
        + localDateTime.getMonth().toString().toLowerCase() + " "
        + localDateTime.getDayOfMonth() + ". "
        + String.format("%02d" , localDateTime.getHour()) + ":"
        + String.format("%02d" , localDateTime.getMinute()) + ":"
        + String.format("%02d" , localDateTime.getSecond()) + " : "
        + action;
  }
}
