package com.greenfox.programmingfoxclub.model.history;

import com.greenfox.programmingfoxclub.model.Trick;
import javax.persistence.Entity;

@Entity
public class TrickAction extends HistoryAction {
  public TrickAction(Trick learnedTrick) {
    super("Learned to: " + learnedTrick.getName());
  }

  public TrickAction() {

  }
}
