package kr.hhplus.be.server.domain.concert.service;

import kr.hhplus.be.server.domain.concert.enums.ConcertSeatStatus;
import kr.hhplus.be.server.domain.concert.mapper.ConcertScheduleMapper;
import kr.hhplus.be.server.domain.concert.mapper.ConcertSeatMapper;
import kr.hhplus.be.server.domain.concert.model.ConcertScheduleProjection;
import kr.hhplus.be.server.domain.concert.model.ConcertSeatProjection;
import kr.hhplus.be.server.domain.concert.repository.ConcertScheduleRepository;
import kr.hhplus.be.server.domain.concert.repository.ConcertSeatRepository;
import kr.hhplus.be.server.dto.ConcertDTO.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConcertService {
    private final ConcertScheduleRepository concertScheduleRepository;
    private final ConcertSeatRepository concertSeatRepository;

    // 1) 예약 가능 날짜 조회 서비스
    @Transactional(readOnly = true)
    public List<AvailableDateResponse> getAvailableDateByConcertId(long concertId) {
        List<ConcertScheduleProjection> schedules = concertScheduleRepository.findAllByConcertIdAndAvailableIsTrue(concertId);
        return ConcertScheduleMapper.INSTANCE.toResponseList(schedules);
    }

    // 1) 예약 가능 날짜 조회 서비스
    @Transactional(readOnly = true)
    public List<AvailableSeatResponse> getAvailableSeatByScheduleId(long scheduleId) {
        List<ConcertSeatProjection> seats = concertSeatRepository.findAllByScheduleIdAndStatus(scheduleId, ConcertSeatStatus.AVAILABLE);
        return ConcertSeatMapper.INSTANCE.toResponseList(seats);
    }
}
