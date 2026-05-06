package com.chatbot.jira_confluence_chatbot.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.chatbot.jira_confluence_chatbot.dto.ChatRequest;
import com.chatbot.jira_confluence_chatbot.dto.ChatResponse;
import com.chatbot.jira_confluence_chatbot.service.ChatService;
import com.chatbot.jira_confluence_chatbot.entity.AccessRequest;
import com.chatbot.jira_confluence_chatbot.repository.AccessRequestRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class ChatController {

    private final ChatService chatService;
    private final AccessRequestRepository accessRequestRepository;


    public ChatController(ChatService chatService,
                          AccessRequestRepository accessRequestRepository) {
        this.chatService = chatService;
        this.accessRequestRepository = accessRequestRepository;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello";
    }

    @PostMapping("/chat")
    public ChatResponse chat(@Valid @RequestBody ChatRequest request) {
        return chatService.processMessage(request.getMessage());
    }

    // 🔥 NEW API
    @GetMapping("/access")
    public List<AccessRequest> getAllAccessRequests() {
        return accessRequestRepository.findAll();
    }
}