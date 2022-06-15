package com.weedprj.springserver.domain.chat.controller;

import com.weedprj.springserver.domain.chat.port.ChatServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class ChatController {
  @Autowired private ChatServicePort service;

  @PostMapping("/chat/room")
  public void makeChatRoom() {}
}
