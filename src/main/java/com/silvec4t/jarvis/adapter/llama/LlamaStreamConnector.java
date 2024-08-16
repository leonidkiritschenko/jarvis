package com.silvec4t.jarvis.adapter.llama;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.model.StreamingResponseHandler;
import dev.langchain4j.model.chat.StreamingChatLanguageModel;
import dev.langchain4j.model.ollama.OllamaStreamingChatModel;
import dev.langchain4j.model.output.Response;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.ollama.OllamaContainer;
import org.testcontainers.utility.DockerImageName;

@Repository
public class LlamaStreamConnector {

  String MODEL_NAME = "llama3";

  StreamingChatLanguageModel model;

  public LlamaStreamConnector() {
    OllamaContainer ollama =
        new OllamaContainer(DockerImageName.parse("langchain4j/ollama-" + MODEL_NAME + ":latest")
            .asCompatibleSubstituteFor("ollama/ollama"));

    ollama.start();

    // Build the ChatLanguageModel
    model = OllamaStreamingChatModel.builder().baseUrl(baseUrl(ollama)).modelName(MODEL_NAME)
        .build();
  }

  public Response<AiMessage> generateStreamResponse(List<ChatMessage> chatMessages) {

    var temp = model.generate(chatMessages, new StreamingResponseHandler<AiMessage>() {

      @Override
      public void onNext(String token) {
        System.out.println("onNext: " + token);
      }

      @Override
      public void onError(Throwable error) {

      }
    });
  }

  private static String baseUrl(GenericContainer<?> ollama) {
    return String.format("http://%s:%d", ollama.getHost(), ollama.getFirstMappedPort());
  }
}
