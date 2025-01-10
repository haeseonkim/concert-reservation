package kr.hhplus.be.server.domain.queueToken.repository;

import kr.hhplus.be.server.domain.queueToken.model.QueueToken;
import kr.hhplus.be.server.domain.queueToken.enums.QueueTokenStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface QueueTokenRepository extends JpaRepository<QueueToken, Long> {
    @Modifying
    @Query("UPDATE QueueToken q SET q.status = :expiredStatus WHERE q.expiredAt < :now AND q.status != :expiredStatus")
    int updateStatusForExpiredTokens(
            @Param("now") LocalDateTime now,
            @Param("expiredStatus") QueueTokenStatus expiredStatus
    );
}
