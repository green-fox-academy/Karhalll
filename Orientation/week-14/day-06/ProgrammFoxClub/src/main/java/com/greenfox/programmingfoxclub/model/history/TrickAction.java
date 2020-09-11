package com.greenfox.programmingfoxclub.model.history;

import com.greenfox.programmingfoxclub.model.HistoryAction;
import com.greenfox.programmingfoxclub.model.Trick;

public class TrickAction extends HistoryAction {
  public TrickAction(Trick learnedTrick) {
    super("Learned to: " + learnedTrick);
  }
}
