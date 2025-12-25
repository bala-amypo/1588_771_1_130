package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "device_ownership")
public class DeviceOwnershipRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String serialNumber;

    private String ownerName;

    private boolean active;

    public DeviceOwnershipRecord() {}

    public DeviceOwnershipRecord(String serialNumber, String ownerName, boolean active) {
        this.serialNumber = serialNumber;
        this.ownerName = ownerName;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
