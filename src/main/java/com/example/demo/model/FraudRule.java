package com.example.demo.model;
import lombok.*;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FraudRule {
    private Long id;
    private String ruleCode;
    private String ruleType;
    private String description;
    private Boolean active;
}
