package com.example.demo.model;
import lombok.*;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StolenDeviceReport {
    private Long id;
    private String serialNumber;
}
