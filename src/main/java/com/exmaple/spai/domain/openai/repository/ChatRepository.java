package com.exmaple.spai.domain.openai.repository;

import com.exmaple.spai.domain.openai.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, Long> {

    List<Chat> findByUserId(String userId);
}
