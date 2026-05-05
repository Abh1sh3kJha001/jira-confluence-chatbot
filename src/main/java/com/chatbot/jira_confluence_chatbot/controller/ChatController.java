package com.chatbot.jira_confluence_chatbot.controller;

import com.chatbot.jira_confluence_chatbot.dto.ChatRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChatController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello 🚀";
    }

    @PostMapping("/chat")
    public String chat(@RequestBody ChatRequest request) {
        return "You said: " + request.getMessage();
    }

    @GetMapping("/bye")
    public String sayBye() {
        return "Bye ";
    }
}