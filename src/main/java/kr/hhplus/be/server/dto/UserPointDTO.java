package kr.hhplus.be.server.dto;

import lombok.Builder;
import lombok.Getter;

public class UserPointDTO {
    private UserPointDTO() {
        throw new IllegalStateException("DTO group class");
    }

    @Getter
    public static class RechargeRequest {
        private long userId;
        private int amount;
    }

    @Getter
    @Builder
    public static class RechargeResponse {
        private int amount;
    }

    @Getter
    @Builder
    public static class UserPointResponse {
        private int amount;
    }

    @Getter
    public static class PaymentRequest {
        private long userId;
        private int amount;
    }

    @Getter
    @Builder
    public static class PaymentResponse {
        private Long paymentId;
        private Long concertId;
        private int seatNum;
        private int amount;
    }
}
