package kr.hhplus.be.server.dto;

import lombok.Builder;
import lombok.Getter;

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
}
