package kr.hhplus.be.server.domain.concert.service;

import kr.hhplus.be.server.domain.concert.enums.ConcertSeatStatus;
import kr.hhplus.be.server.domain.concert.exception.SeatAlreadyReservedException;
import kr.hhplus.be.server.domain.concert.exception.SeatNotFoundException;
import kr.hhplus.be.server.domain.concert.model.ConcertScheduleProjection;
import kr.hhplus.be.server.domain.concert.model.ConcertSeat;
import kr.hhplus.be.server.domain.concert.model.ConcertSeatProjection;
import kr.hhplus.be.server.domain.concert.repository.ConcertScheduleRepository;
import kr.hhplus.be.server.domain.concert.repository.ConcertSeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConcertService {
    private final ConcertScheduleRepository concertScheduleRepository;
    private final ConcertSeatRepository concertSeatRepository;

    private static final int SEAT_HOLD_MINUTES = 5;

    public List<ConcertScheduleProjection> getAvailableDateByConcertId(long concertId) {
        return concertScheduleRepository.findAllByConcertIdAndAvailableIsTrue(concertId);
    }

    public List<ConcertSeatProjection> getAvailableSeatByScheduleId(long scheduleId) {
        return concertSeatRepository.findAllByScheduleIdAndStatus(scheduleId, ConcertSeatStatus.AVAILABLE);
    }

    public ConcertSeat validateSeatExists(long seatId) {
        return concertSeatRepository.findById(seatId)
                .orElseThrow(() -> new SeatNotFoundException(seatId));
    }

    public void isSeatAvailable(ConcertSeat seat) {
        if (seat.getStatus() != ConcertSeatStatus.AVAILABLE) {
            throw new SeatAlreadyReservedException(seat.getId());
        }
    }

    public ConcertSeat holdSeat(ConcertSeat seat, long userId) {
        seat.setStatus(ConcertSeatStatus.HOLD);
        seat.setHoldUntil(LocalDateTime.now().plusMinutes(SEAT_HOLD_MINUTES));
        seat.setUserId(userId);
        return concertSeatRepository.save(seat);
    }

    @Transactional
    public void releaseExpiredSeats() {
        List<ConcertSeat> expiredSeats = concertSeatRepository.findAllByHoldUntilBeforeAndStatus(
                LocalDateTime.now(),
                ConcertSeatStatus.HOLD
        );

        for (ConcertSeat seat : expiredSeats) {
            seat.setStatus(ConcertSeatStatus.AVAILABLE);
            seat.setHoldUntil(null);
            seat.setUserId(null);
        }

        concertSeatRepository.saveAll(expiredSeats);
    }
}
