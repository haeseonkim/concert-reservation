package kr.hhplus.be.server.domain.concert;

import kr.hhplus.be.server.domain.concert.mapper.ConcertScheduleMapper;
import kr.hhplus.be.server.domain.concert.model.ConcertScheduleProjection;
import kr.hhplus.be.server.dto.ConcertDTO;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConcertScheduleMapperTest {

    @Test
    void testMapping() {
        // Given
        ConcertScheduleProjection projection = new ConcertScheduleProjection() {
            @Override
            public Long getId() {
                return 1L;
            }

            @Override
            public LocalDate getScheduleDate() {
                return LocalDate.of(2025, 1, 11);
            }
        };

        // When
        ConcertDTO.AvailableDateResponse response = ConcertScheduleMapper.INSTANCE.toResponse(projection);

        // Then
        assertEquals("2025-01-11", response.getDate());
    }
}
