package kr.hhplus.be.server.domain.queueToken.repository;

import kr.hhplus.be.server.domain.queueToken.model.QueueToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QueueTokenRepository extends JpaRepository<QueueToken, Long> {
}
