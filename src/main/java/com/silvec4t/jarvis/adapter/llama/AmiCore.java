package com.silvec4t.jarvis.adapter.llama;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.model.output.Response;
import java.util.List;

public interface AmiCore {

  Response<AiMessage> chat(List<ChatMessage> chatMessages);


}
