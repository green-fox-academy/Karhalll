package com.greenfoxacademy.springstart;

import java.util.concurrent.atomic.AtomicLong;

public class Greeting {
  private static AtomicLong greetCount = new AtomicLong(0);
  private String content;

  public Greeting(String content) {
    greetCount.addAndGet(1);
    this.content = content;
  }

  public AtomicLong getGreetCount() {
    return greetCount;
  }

  public void setGreetCount(AtomicLong greetCount) {
    Greeting.greetCount = greetCount;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
