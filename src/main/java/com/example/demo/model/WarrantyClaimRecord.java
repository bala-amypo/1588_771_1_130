package com.example.project.models;

import java.time.LocalDateTime;

public class WarrantyClaimRecord {
    private long id;
    private String serialNumber;
    private String claimantName;
    private String claimantEmail;
    private String claimReason;
    private LocalDateTime submittedAt;
    private String status;
    
    public void WarrantyClaimRecord() {}

    public void WarrantyClaimRecord(String serialNumber,String claimantName,String claimantEmail,String claimReason,LocalDateTime submittedAt,String status) {
        this.serialNumber=serialNumber;
        this.claimantName=claimantName;
        this.claimantEmail=claimantEmail;
        this.claimReason=claimReason;
        this.submittedAt=submittedAt;
        this.status=status;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getClaimantName() {
        return claimantName;
    }

    public String getClaimantEmail() {
        return claimantEmail;
    }

    public String getClaimReason() {
        return claimReason;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setClaimantName(String claimantName) {
        this.claimantName = claimantName;
    }

    public void setClaimantEmail(String claimantEmail) {
        this.claimantEmail = claimantEmail;
    }

    public void setClaimReason(String claimReason) {
        this.claimReason = claimReason;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}

