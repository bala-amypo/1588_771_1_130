package com.example.project.models;

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
    
    public FraudAlertRecord() {}

    public FraudAlertRecord(long claimid,String serialNumber,String alertType,String severity,String message,LocalDateTime alertDate,Boolean resolved) {
        this.claimid=claimid;
        this.serialNumber=serialNumber;
        this.alertType=alertType;
        this.severity=severity;
        this.message=message;
        this.alertDate=alertDate;
        this.resolved=resolved;
    }

    public long getClaimid() {
        return claimid;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getAlertType() {
        return alertType;
    }

    public String getSeverity() {
        return severity;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getAlertDate() {
        return alertDate;
    }

    public Boolean getResolved() {
        return resolved;
    }

    public void setClaimid(long claimid) {
        this.claimid = claimid;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setAlertDate(LocalDateTime alertDate) {
        this.alertDate = alertDate;
    }

    public void setResolved(Boolean resolved) {
        this.resolved = resolved;
    }
    
}
