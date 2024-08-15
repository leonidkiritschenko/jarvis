package com.silvec4t.jarvis;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.ollama.OllamaChatModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;
import org.testcontainers.ollama.OllamaContainer;


@SpringBootApplication
public class JarvisApplication {

	public static void main(String[] args) {
		SpringApplication.run(JarvisApplication.class, args);

	}
}
