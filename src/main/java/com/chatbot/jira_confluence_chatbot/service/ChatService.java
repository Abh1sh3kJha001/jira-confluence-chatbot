package com.chatbot.jira_confluence_chatbot.service;

import org.springframework.stereotype.Service;

import com.chatbot.jira_confluence_chatbot.dto.ChatResponse;
import com.chatbot.jira_confluence_chatbot.entity.Chat;
import com.chatbot.jira_confluence_chatbot.entity.AccessRequest;
import com.chatbot.jira_confluence_chatbot.repository.ChatRepository;
import com.chatbot.jira_confluence_chatbot.repository.AccessRequestRepository;

@Service
public class ChatService {

    private final ChatRepository chatRepository;
    private final AccessRequestRepository accessRequestRepository;

    public ChatService(ChatRepository chatRepository,
                       AccessRequestRepository accessRequestRepository) {
        this.chatRepository = chatRepository;
        this.accessRequestRepository = accessRequestRepository;
    }

    public ChatResponse processMessage(String message) {

        if (message == null || message.trim().isEmpty()) {
            throw new RuntimeException("Message cannot be empty");
        }

        String lower = message.toLowerCase();
        String reply;

        if (lower.contains("hello")) {
            reply = "Hi! You can request access to Jira or Confluence.";
        }
        else if (lower.contains("jira")) {
            reply = "Access to Jira has been granted successfully.";

            AccessRequest request = new AccessRequest("JIRA", "GRANTED");
            accessRequestRepository.save(request);

        }
        else if (lower.contains("confluence")) {
            reply = "Access to Confluence has been granted successfully.";

            AccessRequest request = new AccessRequest("CONFLUENCE", "GRANTED");
            accessRequestRepository.save(request);
        }
        else if (lower.contains("access")) {
            reply = "Please specify the tool: Jira or Confluence.";
        }
        else {
            reply = "Sorry, I didn’t understand. Please request access to Jira or Confluence.";
        }

        // Save chat history
        Chat chat = new Chat(message, reply);
        chatRepository.save(chat);

        return new ChatResponse(reply, "success");
    }
}