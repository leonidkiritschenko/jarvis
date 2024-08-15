package com.silvec4t.jarvis.adapter.llama;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.ollama.OllamaChatModel;
import org.springframework.stereotype.Repository;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.ollama.OllamaContainer;
import org.testcontainers.utility.DockerImageName;

@Repository
public class LlamaConnector {

    // The model name to use (e.g., "orca-mini", "mistral", "llama2", "codellama", "phi", or
    // "tinyllama")
    String MODEL_NAME = "llama3";

    ChatLanguageModel model;

    public LlamaConnector() {
        OllamaContainer ollama =
                new OllamaContainer(DockerImageName.parse("langchain4j/ollama-" + MODEL_NAME + ":latest")
                        .asCompatibleSubstituteFor("ollama/ollama"));

        ollama.start();

        // Build the ChatLanguageModel
        model = OllamaChatModel.builder().baseUrl(baseUrl(ollama)).modelName(MODEL_NAME).build();
    }

    public String generateResponse(String userMessage) {
        return model.generate(userMessage);
    }

    private static String baseUrl(GenericContainer<?> ollama) {
        return String.format("http://%s:%d", ollama.getHost(), ollama.getFirstMappedPort());
    }

}
