package kr.hhplus.be.server.domain.queueToken;

import kr.hhplus.be.server.domain.queueToken.model.QueueToken;
import kr.hhplus.be.server.domain.queueToken.model.QueueTokenStatus;
import kr.hhplus.be.server.domain.queueToken.repository.QueueTokenRepository;
import kr.hhplus.be.server.domain.queueToken.service.QueueTokenService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class QueueTokenServiceTest {
    @Mock
    private QueueTokenRepository queueTokenRepository;

    @InjectMocks
    private QueueTokenService queueTokenService;

    @Test
    void 대기열_토큰_생성_성공_테스트() {
        // Given
        Long concertId = 1L;
        Long userId = 100L;
        String expectedToken = "testToken";

        QueueToken mockQueueToken = QueueToken.builder()
                .token(expectedToken)
                .concertId(concertId)
                .userId(userId)
                .status(QueueTokenStatus.WAITING)
                .expiredAt(LocalDateTime.now().plusMinutes(15))
                .build();

        when(queueTokenRepository.save(any(QueueToken.class))).thenReturn(mockQueueToken);

        ArgumentCaptor<QueueToken> queueTokenCaptor = ArgumentCaptor.forClass(QueueToken.class);

        // When
        queueTokenService.createQueueToken(concertId, userId);

        // Then
        verify(queueTokenRepository, times(1)).save(queueTokenCaptor.capture());
        QueueToken queueToken = queueTokenCaptor.getValue();

        assertEquals(concertId, queueToken.getConcertId());
        assertEquals(userId, queueToken.getUserId());
        assertEquals(QueueTokenStatus.WAITING, queueToken.getStatus());
    }

    @Test
    void 토큰_만료_업데이트_성공_테스트() {
        // Given
        QueueTokenStatus expiredStatus = QueueTokenStatus.EXPIRED;

        int updatedCount = 5;
        when(queueTokenRepository.updateStatusForExpiredTokens(any(LocalDateTime.class), eq(expiredStatus)))
                .thenReturn(updatedCount);

        // When
        queueTokenService.updateExpiredTokens();

        // Then
        verify(queueTokenRepository, times(1))
                .updateStatusForExpiredTokens(any(LocalDateTime.class), eq(expiredStatus));
    }
}
