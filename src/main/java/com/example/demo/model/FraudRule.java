package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "fraud_rules")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FraudRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String ruleCode;

    private String ruleType;
    private String description;
    private Boolean active = true;
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        if (active == null) active = true;
        if (createdAt == null) createdAt = LocalDateTime.now();
    }
}
