package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "device_ownership_records")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeviceOwnershipRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String serialNumber;

    private String ownerName;
    private String ownerEmail;
    private LocalDate purchaseDate;
    private LocalDate warrantyExpiration;
    private Boolean active = true;
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        if (active == null) active = true;
        if (createdAt == null) createdAt = LocalDateTime.now();
    }
}
