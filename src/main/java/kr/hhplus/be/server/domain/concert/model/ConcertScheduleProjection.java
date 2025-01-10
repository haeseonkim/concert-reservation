package kr.hhplus.be.server.domain.concert.model;

import java.time.LocalDate;

public interface ConcertScheduleProjection {
    LocalDate getScheduleDate();
}
