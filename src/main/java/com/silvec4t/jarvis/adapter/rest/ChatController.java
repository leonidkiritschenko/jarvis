package com.silvec4t.jarvis.adapter.rest;

import com.silvec4t.jarvis.domain.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    @Autowired
    ChatService chatService;

    @PostMapping(value = "/chat")
    public String postChat(String userMessage) {
        return chatService.generateResponse(userMessage);
    }
}
