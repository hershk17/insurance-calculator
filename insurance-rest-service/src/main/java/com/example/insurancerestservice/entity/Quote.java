package com.example.insurancerestservice.Quote;

import com.example.insurancerestservice.driver.Driver;
import jakarta.persistence.*;
import org.apache.commons.lang3.RandomStringUtils;

@Entity
public class Quote {
    @Id
    private String reference;
    private Boolean success;
    private Double premium;

    @ManyToOne
    @JoinColumn(name = "driver_id") // wwhyyyyyyyyyyyyyyyy
    private Driver driver;

    public Quote() {
        this.reference = 'Q' + RandomStringUtils.randomAlphanumeric(15).toUpperCase();
        this.success = false;
        this.premium = 0.0;
    }

    public Quote(Boolean success, Double premium) {
        super();
        this.success = success;
        this.premium = premium;
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

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "reference='" + reference + '\'' +
                ", success=" + success +
                ", premium=" + premium +
                '}';
    }
}
