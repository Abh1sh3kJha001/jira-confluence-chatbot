package com.chatbot.jira_confluence_chatbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.chatbot.jira_confluence_chatbot.entity.Chat;

public interface ChatRepository extends JpaRepository<Chat, Long> {
}