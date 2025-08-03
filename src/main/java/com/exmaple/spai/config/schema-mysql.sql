# https://github.com/spring-projects/spring-ai/tree/main/memory/repository/spring-ai-model-chat-memory-repository-jdbc/src/main/resources/org/springframework/ai/chat/memory/repository/jdbc
# JdbcChatMemoryRepository를 사용하기 위해 아래 sql 선행 필요
CREATE TABLE IF NOT EXISTS SPRING_AI_CHAT_MEMORY (
    `conversation_id` VARCHAR(36) NOT NULL,
    `content` TEXT NOT NULL,
    `type` ENUM('USER', 'ASSISTANT', 'SYSTEM', 'TOOL') NOT NULL,
    `timestamp` TIMESTAMP NOT NULL,

    INDEX `SPRING_AI_CHAT_MEMORY_CONVERSATION_ID_TIMESTAMP_IDX` (`conversation_id`, `timestamp`)
);