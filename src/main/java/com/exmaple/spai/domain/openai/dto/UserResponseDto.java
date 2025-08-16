package com.exmaple.spai.domain.openai.dto;

public record UserResponseDto(
        String name,
        Long age,
        String address,
        String phoneNumber,
        String zipCode
) {
}
