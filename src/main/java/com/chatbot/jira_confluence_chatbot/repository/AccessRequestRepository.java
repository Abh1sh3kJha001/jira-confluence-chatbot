package com.chatbot.jira_confluence_chatbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.chatbot.jira_confluence_chatbot.entity.AccessRequest;

public interface AccessRequestRepository extends JpaRepository<AccessRequest, Long> {
}