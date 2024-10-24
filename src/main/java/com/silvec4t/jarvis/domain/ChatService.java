package com.silvec4t.jarvis.domain;

import com.silvec4t.jarvis.adapter.llama.AmiCore;
import com.silvec4t.jarvis.adapter.llama.ChatMemoryRepository;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.output.Response;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ChatService {

  @Autowired
  private ChatMemoryRepository chatMemoryRepository;

  @Autowired
  private AmiCoreFactory amiCoreFactory;

  public String generateResponse(String chatId, UserMessage userMessage) {
    AmiCore assistant = amiCoreFactory.create(
        "You behave and speak like Jarvis, the AI assistant.",
        chatMemoryRepository.getChatMemory("assistant"));
    Response<AiMessage> response = assistant.chat(List.of(userMessage));

    log.info("Received response with finishReason: {} tokenUsage: {} and of type: {}",
        response.finishReason(), response.tokenUsage(), response.content().type());
    return response.content().text();
  }
}