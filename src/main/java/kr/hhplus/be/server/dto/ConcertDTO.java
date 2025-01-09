package kr.hhplus.be.server.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
        @JsonFormat(pattern = "yyyy-MM-dd")
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
