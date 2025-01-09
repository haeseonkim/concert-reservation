package kr.hhplus.be.server.domain.concert.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConcertSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long concertId;

    @Column(nullable = false)
    private LocalDate scheduleDate;

    @Column(nullable = false)
    private boolean isAvailable;
}
