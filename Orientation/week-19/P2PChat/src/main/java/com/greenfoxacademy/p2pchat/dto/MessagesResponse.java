package com.greenfoxacademy.p2pchat.dto;

import java.util.List;

public class MessagesResponse {

  private List<Message> messages;
  private Channel channel;

  public MessagesResponse() {
  }

  public List<Message> getMessages() {
    return messages;
  }

  public void setMessages(List<Message> messages) {
    this.messages = messages;
  }

  public Channel getChannel() {
    return channel;
  }

  public void setChannel(Channel channel) {
    this.channel = channel;
  }
}
