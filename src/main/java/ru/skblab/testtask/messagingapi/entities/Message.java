package ru.skblab.testtask.messagingapi.entities;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * Suppose message has content and operation type for outer system
 * Instead of generic I'll use json type for more independent solution
 * */
public class Message {
    private final JsonNode content;
    private final Operation operation;

    public Message(JsonNode content, Operation operation){
        this.content = content;
        this.operation = operation;
    }

    public JsonNode getContent() {
        return content;
    }

    public Operation getOperation() {
        return operation;
    }
}
