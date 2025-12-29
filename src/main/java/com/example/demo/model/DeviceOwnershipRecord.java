package com.example.demo.model;

public class DeviceOwnershipRecord {
    private Long id;
    private String deviceName;
    private String ownerName;
    private String serialNumber;
    private boolean active;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDeviceName() { return deviceName; }
    public void setDeviceName(String deviceName) { this.deviceName = deviceName; }

    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    public String getSerialNumber() { return serialNumber; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
