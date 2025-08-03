package com.exmaple.spai.api;

import com.exmaple.spai.domain.openai.service.OpenAiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ChatController {

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
}
