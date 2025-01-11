package kr.hhplus.be.server.domain.concert.repository;

import kr.hhplus.be.server.domain.concert.enums.ConcertSeatStatus;
import kr.hhplus.be.server.domain.concert.model.ConcertSeat;
import kr.hhplus.be.server.domain.concert.model.ConcertSeatProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConcertSeatRepository extends JpaRepository<ConcertSeat, Long> {
    @Query("SELECT cs.id AS id, cs.seatNum AS seatNum, cs.price AS price " +
            "FROM ConcertSeat cs WHERE cs.scheduleId = :id AND cs.status = :status")
    List<ConcertSeatProjection> findAllByScheduleIdAndStatus(Long id, ConcertSeatStatus status);

}
