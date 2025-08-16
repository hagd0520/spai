package com.exmaple.spai.domain.openai.service;

import com.exmaple.spai.domain.openai.dto.UserResponseDto;
import org.springframework.ai.tool.annotation.Tool;

public class ChatTools {

    @Tool(description = "User Personal information: name, age, address, phone, etc")
    public UserResponseDto getUserInfoTool() {
        return new UserResponseDto("김지훈", 15L, "서울특별시 종로구 청와대로 1", "010-0000-0000", "03048");
    }
}
