package kr.hhplus.be.server.controller;

import kr.hhplus.be.server.domain.concert.service.ConcertService;
import kr.hhplus.be.server.dto.ConcertDTO.*;
import kr.hhplus.be.server.service.ReserveConcertUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/concert")
public class ConcertController {
    private final ConcertService concertService;
    private final ReserveConcertUseCase reserveConcertUseCase;

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

    // 3) 콘서트 예약 (결제 전)
    @PostMapping("/{seatId}/reservation")
    public ResponseEntity<ReservationResponse> reserveConcert(
            @PathVariable long seatId,
            @RequestBody ReservationRequest request
    ) {
        return ResponseEntity.ok(reserveConcertUseCase.execute(seatId, request.getUserId()));
    }
}
