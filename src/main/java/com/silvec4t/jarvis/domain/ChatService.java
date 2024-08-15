package com.silvec4t.jarvis.domain;

import com.silvec4t.jarvis.adapter.llama.LlamaConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    @Autowired
    LlamaConnector llamaConnector;


    public String generateResponse(String userMessage) {
        return llamaConnector.generateResponse(userMessage);
    }
}
