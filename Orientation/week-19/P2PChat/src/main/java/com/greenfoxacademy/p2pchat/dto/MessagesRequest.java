package com.greenfoxacademy.p2pchat.dto;

public class MessagesRequest {

  private String channelId;
  private String channelSecret;
  private Integer count;

  public MessagesRequest() {
  }

  public MessagesRequest(Integer count) {
    this.count = count;
  }

  public String getChannelId() {
    return channelId;
  }

  public void setChannelId(String channelId) {
    this.channelId = channelId;
  }

  public String getChannelSecret() {
    return channelSecret;
  }

  public void setChannelSecret(String channelSecret) {
    this.channelSecret = channelSecret;
  }

  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }
}
