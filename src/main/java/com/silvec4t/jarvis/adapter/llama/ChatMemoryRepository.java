package com.silvec4t.jarvis.adapter.llama;

import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class ChatMemoryRepository {

  private final Map<String, ChatMemory> chatMemoryMap = new HashMap<>();

  public ChatMemory getChatMemory(String chatId) {
    if (chatMemoryMap.containsKey(chatId)) {
      return chatMemoryMap.get(chatId);
    } else {
      ChatMemory chatMemory = MessageWindowChatMemory.builder()
          .id(chatId)
          .maxMessages(10)
          .build();
      chatMemoryMap.put(chatId, chatMemory);
      return chatMemory;
    }
  }
}
