package kr.hhplus.be.server.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

public class QueueTokenDTO {
    private QueueTokenDTO() {
        throw new IllegalStateException("DTO group class");
    }

    @Getter
    @Builder
    public static class CreateQueueTokenRequest {
        private long userId;
        private long concertId;
    }

    @Getter
    @Builder
    public static class CreateQueueTokenResponse {
        private long userId;
        private long concertId;
        private String token;
        private boolean isActive;
        private LocalDateTime expiredAt;
    }
}
