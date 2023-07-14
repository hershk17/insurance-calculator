package com.example.insurancerestservice.entity;

import jakarta.persistence.*;
import org.apache.commons.lang3.RandomStringUtils;

@Entity
public class Quote {
    @Id
    private String reference;
    private Boolean success;
    private Double premium;

    private long driverId;

    public Quote() {
        this.reference = 'Q' + RandomStringUtils.randomAlphanumeric(15).toUpperCase();
        this.success = false;
        this.premium = 0.0;
    }

    public String getReference() {
        return reference;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Double getPremium() {
        return premium;
    }

    public void setPremium(Double premium) {
        this.premium = premium;
    }

    public long getDriverId() {
        return driverId;
    }

    public void setDriverId(long driverId) {
        this.driverId = driverId;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "reference='" + reference + '\'' +
                ", success=" + success +
                ", premium=" + premium +
                ", driverId=" + driverId +
                '}';
    }
}
