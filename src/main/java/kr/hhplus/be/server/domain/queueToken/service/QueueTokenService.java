package kr.hhplus.be.server.domain.queueToken.service;

import kr.hhplus.be.server.domain.queueToken.model.QueueToken;
import kr.hhplus.be.server.domain.queueToken.model.QueueTokenStatus;
import kr.hhplus.be.server.domain.queueToken.repository.QueueTokenRepository;
import kr.hhplus.be.server.dto.QueueTokenDTO.*;
import kr.hhplus.be.server.domain.queueToken.mapper.QueueTokenMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class QueueTokenService {
    private static final long EXPIRATION_MINUTES = 15;

    private final QueueTokenRepository queueTokenRepository;

    @Transactional
    public CreateQueueTokenResponse createQueueToken(Long concertId, Long userId) {

        String token = UUID.randomUUID().toString();

        LocalDateTime expiredAt = LocalDateTime.now().plusMinutes(EXPIRATION_MINUTES);

        QueueToken queueToken = QueueToken.builder()
                .token(token)
                .concertId(concertId)
                .userId(userId)
                .status(QueueTokenStatus.WAITING)
                .expiredAt(expiredAt)
                .build();

        return QueueTokenMapper.INSTANCE.toWebDto(queueTokenRepository.save(queueToken));
    }

    @Scheduled(cron = "0 * * * * *")
    @Transactional
    public void updateExpiredTokens() {
        int updatedCount = queueTokenRepository.updateStatusForExpiredTokens(LocalDateTime.now(), QueueTokenStatus.EXPIRED);
        System.out.println(updatedCount + " expired tokens are updated to EXPIRED status.");
    }
}
