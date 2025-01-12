package kr.hhplus.be.server.service;

import kr.hhplus.be.server.domain.concert.mapper.ConcertScheduleMapper;
import kr.hhplus.be.server.domain.concert.mapper.ConcertSeatMapper;
import kr.hhplus.be.server.domain.concert.model.ConcertScheduleProjection;
import kr.hhplus.be.server.domain.concert.model.ConcertSeatProjection;
import kr.hhplus.be.server.domain.concert.service.ConcertService;
import kr.hhplus.be.server.dto.ConcertDTO.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FetchConcertDetailsUseCase {
    private final ConcertService concertService;

    @Transactional(readOnly = true)
    public List<AvailableDateResponse> executeFetchDates(long concertId) {
        List<ConcertScheduleProjection> schedules = concertService.getAvailableDateByConcertId(concertId);
        return ConcertScheduleMapper.INSTANCE.toResponseList(schedules);
    }

    @Transactional(readOnly = true)
    public List<AvailableSeatResponse> executeFetchSeats(long scheduleId) {
        List<ConcertSeatProjection> seats =  concertService.getAvailableSeatByScheduleId(scheduleId);
        return ConcertSeatMapper.INSTANCE.toResponseList(seats);
    }
}

