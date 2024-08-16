package com.silvec4t.jarvis.domain;

import com.silvec4t.jarvis.adapter.llama.ChatMemoryRepository;
import com.silvec4t.jarvis.adapter.llama.LlamaConnector;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.model.output.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ChatService {

  @Autowired
  private LlamaConnector llamaConnector;

  @Autowired
  private ChatMemoryRepository chatMemoryRepository;


  public String generateResponse(String chatId, UserMessage userMessage) {
    ChatMemory chatMemory = chatMemoryRepository.getChatMemory(chatId);

    chatMemory.add(userMessage);

    Response<AiMessage> response = llamaConnector.generateResponse(chatMemory.messages());

    chatMemory.add(response.content());

    log.info("Received response with finishReason: {} tokenUsage: {} and of type: {}",
        response.finishReason(), response.tokenUsage(), response.content().type());
    return response.content().text();
  }
}
