package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "stolen_device_reports")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StolenDeviceReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String serialNumber;

    @Column(nullable = false)
    private String reportedBy;

    private String details;

    private LocalDateTime reportDate;

    @PrePersist
    void onCreate() {
        this.reportDate = LocalDateTime.now();
    }
}
