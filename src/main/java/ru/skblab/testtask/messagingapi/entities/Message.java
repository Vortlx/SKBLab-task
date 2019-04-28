package ru.skblab.testtask.messagingapi.entities;

import com.fasterxml.jackson.databind.JsonNode;

// ToDo Create jar library
/**
 * Suppose message has content and operation type for outer system
 * Instead of generic I'll use json type for more independent solution
 * */
public class Message {
    private JsonNode content;
    private Operation operation;

    public Message(){}

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

    public void setContent(JsonNode content) {
        this.content = content;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}
