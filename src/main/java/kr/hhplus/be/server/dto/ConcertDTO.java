package kr.hhplus.be.server.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

public class ConcertDTO {
    private ConcertDTO() {
        throw new IllegalStateException("DTO group class");
    }

    @Getter
    @Builder
    public static class AvailableDateResponse {
        private Long id;
        private String date;
    }

    @Getter
    @Builder
    public static class AvailableSeatResponse {
        private Long id;
        private int seatNum;
        private int price;
    }

    @Getter
    public static class ReservationRequest {
        private long userId;
    }

    @Getter
    @Builder
    public static class ReservationResponse {
        private Long Id;
        private Long userId;
        private int seatNum;
        private String status;
        private LocalDateTime holdUntil;
    }
}
