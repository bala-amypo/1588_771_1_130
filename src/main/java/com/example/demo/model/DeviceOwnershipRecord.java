package com.example.project.models;

import java.time.LocalDate;

public class DeviceOwnershipRecord {
    private  long id;
    private String serialNumber;
    private String ownerName;
    private String ownerEmail;
    private LocalDate purchaseDate;
    private LocalDate warrantyExpiration;
    private Boolean active;
    
    public DeviceOwnershipRecord() {}

    public DeviceOwnershipRecord(String serialNumber,String ownerName,String ownerEmail,LocalDate puchaseDate,LocalDate warrantyExpiration,Boolean active) {
        this.serialNumber=serialNumber;
        this.ownerName=ownerName;
        this.ownerEmail=ownerEmail;
        this.purchaseDate=purchaseDate;
        this.warrantyExpiration=warrantyExpiration;
        this.active=active;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public LocalDate getWarrantyExpiration() {
        return warrantyExpiration;
    }

    public Boolean getActive() {
        return active;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setWarrantyExpiration(LocalDate warrantyExpiration) {
        this.warrantyExpiration = warrantyExpiration;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
