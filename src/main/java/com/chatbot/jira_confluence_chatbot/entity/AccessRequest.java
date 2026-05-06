package com.chatbot.jira_confluence_chatbot.entity;

import jakarta.persistence.*;

@Entity
public class AccessRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tool;   // JIRA / CONFLUENCE
    private String status; // GRANTED / REJECTED

    public AccessRequest() {}

    public AccessRequest(String tool, String status) {
        this.tool = tool;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getTool() {
        return tool;
    }

    public String getStatus() {
        return status;
    }
}