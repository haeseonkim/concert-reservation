package kr.hhplus.be.server.domain.queueToken.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueueToken {
    private static final long EXPIRATION_MINUTES = 15;

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
    @Builder.Default
    @Column(nullable = false)
    private QueueTokenStatus status = QueueTokenStatus.WAITING;

    @Column(nullable = false)
    private LocalDateTime expiredAt;

    @PrePersist
    public void prePersist() {
        if (this.expiredAt == null) {
            this.expiredAt = LocalDateTime.now().plusMinutes(EXPIRATION_MINUTES);
        }
    }
}
