package kr.hhplus.be.server.domain.queueToken;

import kr.hhplus.be.server.domain.queueToken.model.QueueToken;
import kr.hhplus.be.server.domain.queueToken.repository.QueueTokenRepository;
import kr.hhplus.be.server.domain.queueToken.service.QueueTokenService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class QueueTokenServiceTest {
    @Mock
    private QueueTokenRepository queueTokenRepository;

    @InjectMocks
    private QueueTokenService queueTokenService;

    @Test
    @DisplayName("대기열 토큰 생성 테스트")
    void createQueueTokenTest() {
        // Given
        Long concertId = 1L;
        Long userId = 100L;
        String expectedToken = "testToken";

        QueueToken mockQueueToken = QueueToken.builder()
                .token(expectedToken)
                .concertId(concertId)
                .userId(userId)
                .isActive(false)
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
        assertFalse(queueToken.isActive());
    }
}
