package com.silvec4t.jarvis.domain;

import com.silvec4t.jarvis.adapter.llama.AmiCore;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.service.AiServices;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class AmiCoreFactory {

  private Map<String, AmiCore> amiCoreMap = new HashMap<>();

  public AmiCore create(String systemMessage, ChatMemory chatMemory) {
    String MODEL_NAME = "llama3.2:1b";

    if (!amiCoreMap.containsValue(systemMessage)) {
      AmiCore amiCore = AiServices.builder(AmiCore.class)
          .chatLanguageModel(OllamaChatModel.builder()
              .baseUrl("http://localhost:11434")
              .modelName(MODEL_NAME)
              .temperature(0.8)
              .timeout(Duration.ofSeconds(60))
              .build())
          .chatMemory(chatMemory)
          .systemMessageProvider(id -> systemMessage)
          .build();
      amiCoreMap.put(systemMessage, amiCore);
    }
    return amiCoreMap.get(systemMessage);
  }
}
