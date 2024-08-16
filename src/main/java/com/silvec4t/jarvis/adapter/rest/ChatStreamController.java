package com.silvec4t.jarvis.adapter.rest;

import com.silvec4t.jarvis.domain.ChatStreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v2")
public class ChatStreamController {

  @Autowired
  private ChatStreamService chatStreamService;

  @PostMapping(value = "/chat/{chatId}")
  public String postChat(@PathVariable String chatId, String userMessage) {

  }

}
