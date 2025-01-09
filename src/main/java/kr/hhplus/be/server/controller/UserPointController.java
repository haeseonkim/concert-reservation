package kr.hhplus.be.server.controller;

import kr.hhplus.be.server.dto.UserPointDTO.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user-point")
public class UserPointController {
    // 1) 잔액 충전
    @PostMapping("/recharge")
    public ResponseEntity<RechargeResponse> rechargeBalance(@RequestBody RechargeRequest request) {
        // TODO: 잔액 충전 로직 추가
        return ResponseEntity.ok(RechargeResponse.builder().amount(1000).build());
    }

    // 2) 잔액 조회
    @GetMapping("/{userId}")
    public ResponseEntity<UserPointResponse> getBalance(@PathVariable long userId) {
        // TODO: 잔액 조회 로직 추가
        return ResponseEntity.ok(UserPointResponse.builder().amount(500).build());
    }

    // 3) 결제
    @PostMapping("/payment")
    public ResponseEntity<PaymentResponse> makePayment(@RequestBody PaymentRequest request) {
        // TODO: 결제 처리 로직 추가
        return ResponseEntity.ok(
                PaymentResponse.builder()
                        .paymentId(1L)
                        .concertId(2L)
                        .seatNum(3)
                        .amount(100)
                        .build());
    }
}
