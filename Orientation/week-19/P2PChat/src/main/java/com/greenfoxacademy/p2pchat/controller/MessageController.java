package com.greenfoxacademy.p2pchat.controller;

import com.greenfoxacademy.p2pchat.dto.MessagesRequest;
import com.greenfoxacademy.p2pchat.dto.MessagesResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/messages")
public class MessageController {

  private final String rootUrl = "https://rascals-chat.herokuapp.com/API/CHANNEL";


  @GetMapping("/{apiKey}")
  public String showChat(@PathVariable String apiKey, Model model) {

    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders requestHeaders = new HttpHeaders();

    requestHeaders.add("apiKey", apiKey);
    HttpEntity<MessagesRequest> request = new HttpEntity<>(new MessagesRequest(1000), requestHeaders);
    MessagesResponse response = restTemplate.postForObject(rootUrl + "/get-messages", request, MessagesResponse.class);

    model.addAttribute("messages", response.getMessages());

    return "chat";
  }
}
