package kr.hhplus.be.server.domain.userPoint.model;

import jakarta.persistence.*;
import kr.hhplus.be.server.domain.userPoint.enums.TransactionType;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserPointHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType action;

    @Column(nullable = false)
    private int amount;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime transactionAt;
}
