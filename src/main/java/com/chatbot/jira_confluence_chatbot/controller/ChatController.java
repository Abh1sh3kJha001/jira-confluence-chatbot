package com.chatbot.jira_confluence_chatbot.controller;

import org.springframework.web.bind.annotation.*;

import com.chatbot.jira_confluence_chatbot.dto.ChatRequest;
import com.chatbot.jira_confluence_chatbot.dto.ChatResponse;
import com.chatbot.jira_confluence_chatbot.service.ChatService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello";
    }

    @PostMapping("/chat")
    public ChatResponse chat(@Valid @RequestBody ChatRequest request) {
        return chatService.processMessage(request.getMessage());
    }
}