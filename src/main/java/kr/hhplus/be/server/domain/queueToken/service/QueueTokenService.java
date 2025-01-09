package kr.hhplus.be.server.domain.queueToken.service;

import kr.hhplus.be.server.domain.queueToken.model.QueueToken;
import kr.hhplus.be.server.domain.queueToken.repository.QueueTokenRepository;
import kr.hhplus.be.server.dto.QueueTokenDTO.*;
import kr.hhplus.be.server.mapper.QueueTokenMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class QueueTokenService {
    private final QueueTokenRepository queueTokenRepository;

    @Transactional
    public CreateQueueTokenResponse createQueueToken(Long concertId, Long userId) {

        String token = UUID.randomUUID().toString();

        QueueToken queueToken = QueueToken.builder()
                .token(token)
                .concertId(concertId)
                .userId(userId)
                .build();

        return QueueTokenMapper.INSTANCE.toWebDto(queueTokenRepository.save(queueToken));
    }
}
