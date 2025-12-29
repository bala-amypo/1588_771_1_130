package com.example.demo.model;

import java.time.LocalDate;

public class DeviceOwnershipRecord {
    private Long id;
    private String serialNumber;
    private String ownerName;
    private LocalDate warrantyExpiration; // <-- add this field

    private boolean active;

    // Constructors
    public DeviceOwnershipRecord() {}

    public DeviceOwnershipRecord(Long id, String serialNumber, String ownerName, LocalDate warrantyExpiration, boolean active) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.ownerName = ownerName;
        this.warrantyExpiration = warrantyExpiration;
        this.active = active;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSerialNumber() { return serialNumber; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }

    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    public LocalDate getWarrantyExpiration() { return warrantyExpiration; } // <-- getter
    public void setWarrantyExpiration(LocalDate warrantyExpiration) { this.warrantyExpiration = warrantyExpiration; } // <-- setter

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
