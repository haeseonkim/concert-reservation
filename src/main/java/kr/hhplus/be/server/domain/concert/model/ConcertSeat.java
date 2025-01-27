package kr.hhplus.be.server.domain.concert.model;

import jakarta.persistence.*;
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

    @Column(nullable = false)
    private String status;

    private LocalDateTime reservedAt;

    private LocalDateTime tempReservedAt;
}
