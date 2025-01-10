package kr.hhplus.be.server.domain.queueToken.model;

import jakarta.persistence.*;
import kr.hhplus.be.server.domain.queueToken.enums.QueueTokenStatus;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueueToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private Long concertId;

    @Column(nullable = false)
    private Long userId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private QueueTokenStatus status;

    @Column(nullable = false)
    private LocalDateTime expiredAt;
}
