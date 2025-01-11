package kr.hhplus.be.server.dto;

import lombok.Builder;
import lombok.Getter;

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
        private int seatNum;
    }

    @Getter
    @Builder
    public static class ReservationResponse {
        private int seatNum;
        private String status;
    }
}
