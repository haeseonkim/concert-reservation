package kr.hhplus.be.server.domain.concert.service;

import kr.hhplus.be.server.domain.concert.enums.PaymentStatus;
import kr.hhplus.be.server.domain.concert.model.ConcertReservation;
import kr.hhplus.be.server.domain.concert.model.ConcertSeat;
import kr.hhplus.be.server.domain.concert.repository.ConcertReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ConcertReservationService {
    private final ConcertReservationRepository concertReservationRepository;

    public void createReservation(ConcertSeat seat, long userId) {
        ConcertReservation reservation = ConcertReservation.builder()
                .seatId(seat.getId())
                .userId(userId)
                .reservedAt(LocalDateTime.now())
                .paymentStatus(PaymentStatus.PENDING)
                .build();

        concertReservationRepository.save(reservation);
    }
}
