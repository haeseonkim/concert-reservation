package kr.hhplus.be.server.controller;

import kr.hhplus.be.server.dto.QueueTokenDTO.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/queue-token")
public class QueueTokenController {

    // 1) 대기열 토큰 발급
    @PostMapping
    public ResponseEntity<String> createQueueToken(@RequestBody CreateQueueTokenRequest request) {
        // TODO: UUID 토큰 생성 로직 추가
        return ResponseEntity.ok("ImExampleToken");
    }
}
