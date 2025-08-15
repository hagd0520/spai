package com.exmaple.spai.api;

import com.exmaple.spai.domain.openai.entity.Chat;
import com.exmaple.spai.domain.openai.service.ChatService;
import com.exmaple.spai.domain.openai.service.OpenAiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;
    private final OpenAiService openAiService;

    @GetMapping("/")
    public String chatPage() {
        return "chat";
    }

    @ResponseBody
    @PostMapping("/chat")
    public String chat(@RequestBody Map<String, String> body) {
        return openAiService.generate(body.get("text"));
    }

    @ResponseBody
    @PostMapping("/chat/stream")
    public Flux<String> streamChat(@RequestBody Map<String, String> body) {
        return openAiService.generateStream(body.get("text"));
    }

    @ResponseBody
    @PostMapping("/chat/history/{userId}")
    public List<Chat> getChatHistory(@PathVariable String userId) {
        List<Chat> chats = chatService.readAllChats(userId);
        for (Chat chat : chats) {
            System.out.println("chat = " + chat);
        }
        return chats;
    }
}
