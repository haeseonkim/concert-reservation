package kr.hhplus.be.server.config;

import kr.hhplus.be.server.domain.concert.service.ConcertService;
import kr.hhplus.be.server.domain.queueToken.service.QueueTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UnifiedScheduler {
    private final QueueTokenService queueTokenService;
    private final ConcertService concertService;

    @Scheduled(cron = "0 * * * * *")
    public void executeScheduledTasks() {
        queueTokenService.updateExpiredTokens();
        concertService.releaseExpiredSeats();
    }
}
