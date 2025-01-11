package kr.hhplus.be.server.controller;

import kr.hhplus.be.server.domain.concert.service.ConcertService;
import kr.hhplus.be.server.dto.ConcertDTO.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/concert")
public class ConcertController {
    private final ConcertService concertService;
    // 1) 콘서트 예약 가능한 날짜 조회
    @GetMapping("/{id}/dates")
    public ResponseEntity<List<AvailableDateResponse>> getAvailableDates(@PathVariable long id) {
        return ResponseEntity.ok(concertService.getAvailableDateByConcertId(id));
    }

    // 2) 예약 가능한 좌석 조회
    @GetMapping("/{id}/seats")
    public ResponseEntity<List<AvailableSeatResponse>> getAvailableSeats(@PathVariable long id) {
        return ResponseEntity.ok(concertService.getAvailableSeatByScheduleId(id));
    }

    // 3) 콘서트 예약
    @PostMapping("/{id}/reservation")
    public ResponseEntity<ReservationResponse> reserveConcert(
            @PathVariable long id,
            @RequestBody ReservationRequest request
    ) {
        // TODO: 예약 처리 로직 추가
        ReservationResponse response = ReservationResponse.builder()
                .seatNum(request.getSeatNum())
                .status("CONFIRMED")
                .build();
        return ResponseEntity.ok(response);
    }
}
