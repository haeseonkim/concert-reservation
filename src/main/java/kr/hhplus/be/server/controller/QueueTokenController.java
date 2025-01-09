package kr.hhplus.be.server.controller;

import kr.hhplus.be.server.domain.queueToken.service.QueueTokenService;
import kr.hhplus.be.server.dto.QueueTokenDTO.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/queue-token")
public class QueueTokenController {
    private final QueueTokenService queueTokenService;

    // 1) 대기열 토큰 발급
    @PostMapping
    public ResponseEntity<CreateQueueTokenResponse> createQueueToken(@RequestBody CreateQueueTokenRequest request) {
        return ResponseEntity.ok(queueTokenService.createQueueToken(request.getConcertId(), request.getUserId()));
    }
}
