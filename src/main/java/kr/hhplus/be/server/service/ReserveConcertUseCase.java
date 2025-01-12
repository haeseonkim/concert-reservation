package kr.hhplus.be.server.service;

import kr.hhplus.be.server.domain.concert.mapper.ConcertSeatMapper;
import kr.hhplus.be.server.domain.concert.model.ConcertSeat;
import kr.hhplus.be.server.domain.concert.service.ConcertService;
import kr.hhplus.be.server.dto.ConcertDTO.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReserveConcertUseCase {
    private final ConcertService concertService;

    @Transactional
    public ReservationResponse execute(long seatId, long userId) {

        ConcertSeat seat = concertService.validateSeatExists(seatId);

        concertService.isSeatAvailable(seat);

        ConcertSeat reservedSeat = concertService.holdSeat(seat, userId);

        concertService.createReservation(reservedSeat, userId);

        return ConcertSeatMapper.INSTANCE.toReservationResponse(reservedSeat);
    }
}
