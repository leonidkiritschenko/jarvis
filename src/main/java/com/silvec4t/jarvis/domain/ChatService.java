package com.silvec4t.jarvis.domain;

import com.silvec4t.jarvis.adapter.llama.LlamaConnector;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.output.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ChatService {

    @Autowired
    LlamaConnector llamaConnector;


    public String generateResponse(UserMessage userMessage) {
        Response<AiMessage> response = llamaConnector.generateResponse(userMessage);

        log.info("Received response with finishReason: {} tokenUsage: {} and of type: {}", response.finishReason(), response.tokenUsage(), response.content().type());
        return response.content().text();
    }
}
