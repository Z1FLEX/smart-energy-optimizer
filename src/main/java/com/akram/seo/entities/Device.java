package com.akram.seo.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "devices")
@Builder @AllArgsConstructor @NoArgsConstructor
public class Device {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    private String name;
    private String type;
    private String model;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "chip_id")
    private String chipId;

    @Column(name = "mac_address")
    private String macAddress;

    @Column(name = "ip_address")
    private String ipAddress;

    private String location;
    private double wattRating;

    @Enumerated(EnumType.STRING)
    private DeviceStatus status;

    private String certificate;

    @CreationTimestamp
    @Column(name="created_at")
    private Instant createdAt;

    public enum DeviceStatus { ON, OFF, IDLE, ERROR }



    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public Organization getOrganization() {
        return organization;
    }
    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getChipId() {
        return chipId;
    }
    public void setChipId(String chipId) {
        this.chipId = chipId;
    }

    public String getMacAddress() {
        return macAddress;
    }
    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getIpAddress() {
        return ipAddress;
    }
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public double getWattRating() {
        return wattRating;
    }
    public void setWattRating(double wattRating) {
        this.wattRating = wattRating;
    }

    public DeviceStatus getStatus() {
        return status;
    }
    public void setStatus(DeviceStatus status) {
        this.status = status;
    }

    public String getCertificate() {
        return certificate;
    }
    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

}
