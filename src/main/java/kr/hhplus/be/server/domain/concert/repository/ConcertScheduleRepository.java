package kr.hhplus.be.server.domain.concert.repository;

import kr.hhplus.be.server.domain.concert.model.ConcertSchedule;
import kr.hhplus.be.server.domain.concert.model.ConcertScheduleProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConcertScheduleRepository extends JpaRepository<ConcertSchedule, Long> {
    @Query("SELECT cs.id AS id, cs.scheduleDate AS scheduleDate " +
            "FROM ConcertSchedule cs WHERE cs.concertId = :id AND cs.isAvailable = true")
    List<ConcertScheduleProjection> findAllByConcertIdAndAvailableIsTrue(Long id);
}
