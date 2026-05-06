package com.chatbot.jira_confluence_chatbot.service;

import org.springframework.stereotype.Service;
import com.chatbot.jira_confluence_chatbot.dto.ChatResponse;

@Service
public class ChatService {

    public ChatResponse processMessage(String message) {

        String reply;

        if (message == null || message.trim().isEmpty()) {
            throw new RuntimeException("Message cannot be empty");
        }

        String lower = message.toLowerCase();

        if (lower.contains("hello")) {
            reply = "Hi! How can I help you?";
        } else if (lower.contains("jira")) {
            reply = "Jira is used for issue tracking and project management.";
        } else if (lower.contains("confluence")) {
            reply = "Confluence is used for documentation and knowledge sharing.";
        } else if (lower.contains("bye")) {
            reply = "Goodbye! 👋";
        } else {
            reply = "Sorry, I didn’t understand that.";
        }

        return new ChatResponse(reply, "success");
    }
}