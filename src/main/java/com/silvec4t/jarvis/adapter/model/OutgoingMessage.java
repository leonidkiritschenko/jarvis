package com.silvec4t.jarvis.adapter.model;

import lombok.Builder;

@Builder
public record OutgoingMessage(
    String userMessage
) {

}
