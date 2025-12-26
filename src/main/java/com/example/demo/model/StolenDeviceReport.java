package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "stolen_device_reports")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StolenDeviceReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serialNumber;
    private String reportedBy;
    private String details;
    private LocalDateTime reportDate;

    @PrePersist
    public void prePersist() {
        if (reportDate == null) reportDate = LocalDateTime.now();
    }
}
