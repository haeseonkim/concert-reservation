package kr.hhplus.be.server.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

public class ConcertDTO {
    private ConcertDTO() {
        throw new IllegalStateException("DTO group class");
    }

    @Getter
    @Builder
    public static class AvailableDateResponse {
        private LocalDate date;
    }

    @Getter
    @Builder
    public static class GetConcertSeatResponse {
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
