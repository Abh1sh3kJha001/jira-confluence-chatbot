package com.chatbot.jira_confluence_chatbot.dto;

public class ChatResponse {

    private String message;
    private String status;

    public ChatResponse(String message, String status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }
}