package com.example.demo.model;

import java.time.LocalDateTime;

public class FraudAlertRecord {
    private long id;
    private long claimid;
    private String serialNumber;
    private String alertType;
    private String severity;
    private String message;
    private LocalDateTime alertDate;
    private Boolean resolved;
    
}
