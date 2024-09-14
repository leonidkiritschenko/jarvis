package com.silvec4t.jarvis.adapter.llama;

import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class ChatMemoryRepository {

  private Map<String, MessageWindowChatMemory> messageWindowChatMemoryMap = new HashMap<>();

  public ChatMemory getChatMemory(String chatId) {
    if (messageWindowChatMemoryMap.containsKey(chatId)) {
      return messageWindowChatMemoryMap.get(chatId);
    } else {
      MessageWindowChatMemory memory = MessageWindowChatMemory.builder()
          .id(chatId)
          .maxMessages(10)
          .build();
      messageWindowChatMemoryMap.put(chatId, memory);
      return memory;
    }
  }
}
