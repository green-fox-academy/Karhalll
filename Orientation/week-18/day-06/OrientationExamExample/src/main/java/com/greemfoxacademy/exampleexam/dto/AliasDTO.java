package com.greemfoxacademy.exampleexam.dto;

public class AliasDTO {

  private final int id;
  private final String url;
  private final String alias;
  private final int hitCount;

  public AliasDTO(int id, String url, String alias, int hitCount) {
    this.id = id;
    this.url = url;
    this.alias = alias;
    this.hitCount = hitCount;
  }

  public int getId() {
    return id;
  }

  public String getUrl() {
    return url;
  }

  public String getAlias() {
    return alias;
  }

  public int getHitCount() {
    return hitCount;
  }
}
