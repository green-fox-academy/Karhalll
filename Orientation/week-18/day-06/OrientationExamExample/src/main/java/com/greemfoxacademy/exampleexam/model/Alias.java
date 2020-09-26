package com.greemfoxacademy.exampleexam.model;

import java.util.Random;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Alias {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String url;
  private String alias;
  private int hitCount;
  private String secretCode;

  public Alias() {
  }

  public Alias(String url, String alias) {
    this.url = url;
    this.alias = alias;

    this.secretCode = generateSecretCode(4);
  }

  private String generateSecretCode(int digits) {
    Random random = new Random();
    StringBuilder randomSecretCode = new StringBuilder();

    for (int i = 0; i < digits; i++) {
      randomSecretCode.append(random.nextInt(10));
    }
    return randomSecretCode.toString();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getAlias() {
    return alias;
  }

  public void setAlias(String alias) {
    this.alias = alias;
  }

  public int getHitCount() {
    return hitCount;
  }

  public void setHitCount(int hitCount) {
    this.hitCount = hitCount;
  }

  public String getSecretCode() {
    return secretCode;
  }

  public void setSecretCode(String secretCode) {
    this.secretCode = secretCode;
  }
}
