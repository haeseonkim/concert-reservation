package kr.hhplus.be.server.domain.concert.repository;

import kr.hhplus.be.server.domain.concert.model.ConcertReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcertReservationRepository extends JpaRepository<ConcertReservation, Long> {
}
