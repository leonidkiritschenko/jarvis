package com.silvec4t.jarvis.adapter.rest;

import com.silvec4t.jarvis.domain.ChatService;
import dev.langchain4j.data.message.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class ChatController {

    @Autowired
    ChatService chatService;

    @PostMapping(value = "/chat")
    public String postChat(String userMessage) {

        return chatService.generateResponse(UserMessage.from(userMessage));
    }
}
