package com.exmaple.spai.domain.openai.service;

import com.exmaple.spai.domain.openai.entity.Chat;
import com.exmaple.spai.domain.openai.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRepository chatRepository;

    @Transactional(readOnly = true)
    public List<Chat> readAllChats(String userId) {
        return chatRepository.findByUserId(userId);
    }
}
