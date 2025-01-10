package kr.hhplus.be.server.domain.concert.model;

import jakarta.persistence.*;
import kr.hhplus.be.server.domain.concert.enums.ConcertSeatStatus;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConcertSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long scheduleId;

    @Column(nullable = false)
    private int seatNum;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private Long userId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ConcertSeatStatus status;

    private LocalDateTime reservedAt;

    private LocalDateTime tempReservedAt;
}
