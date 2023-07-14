package com.example.insurancerestservice.driver;

import com.example.insurancerestservice.Quote.Quote;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Driver {
    @jakarta.persistence.Id
    @Id
    private String licenseNo;

    private String name;
    private Integer age;
    private Integer experience;
    private Integer faults;

    private Integer vehicleAge;
    private Double vehiclePurchasePrice;
    private Double vehicleAnnualMileage;

    private Integer insuranceCount;
    private Integer insuranceClaims;

    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    private List<Quote> insuranceQuotes;

    public Driver() {
        this.licenseNo = "";
        this.name = "";
        this.age = -1;
        this.experience = -1;
        this.faults = -1;
        this.vehicleAge = -1;
        this.vehiclePurchasePrice = -1.0;
        this.vehicleAnnualMileage = -1.0;
        this.insuranceCount = -1;
        this.insuranceClaims = -1;
        this.insuranceQuotes = null;
    }

    public Driver(String licenseNo, String name, Integer age, Integer experience, Integer faults, Integer vehicleAge, Double vehiclePurchasePrice, Double vehicleAnnualMileage, Integer insuranceCount, Integer insuranceClaims) {
        this.licenseNo = licenseNo;
        this.name = name;
        this.age = age;
        this.experience = experience;
        this.faults = faults;
        this.vehicleAge = vehicleAge;
        this.vehiclePurchasePrice = vehiclePurchasePrice;
        this.vehicleAnnualMileage = vehicleAnnualMileage;
        this.insuranceCount = insuranceCount;
        this.insuranceClaims = insuranceClaims;
        this.insuranceQuotes = new ArrayList<Quote>();
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Integer getFaults() {
        return faults;
    }

    public void setFaults(Integer faults) {
        this.faults = faults;
    }

    public Integer getVehicleAge() {
        return vehicleAge;
    }

    public void setVehicleAge(Integer vehicleAge) {
        this.vehicleAge = vehicleAge;
    }

    public Double getVehiclePurchasePrice() {
        return vehiclePurchasePrice;
    }

    public void setVehiclePurchasePrice(Double vehiclePurchasePrice) {
        this.vehiclePurchasePrice = vehiclePurchasePrice;
    }

    public Double getVehicleAnnualMileage() {
        return vehicleAnnualMileage;
    }

    public void setVehicleAnnualMileage(Double vehicleAnnualMileage) {
        this.vehicleAnnualMileage = vehicleAnnualMileage;
    }

    public Integer getInsuranceCount() {
        return insuranceCount;
    }

    public void setInsuranceCount(Integer insuranceCount) {
        this.insuranceCount = insuranceCount;
    }

    public Integer getInsuranceClaims() {
        return insuranceClaims;
    }

    public void setInsuranceClaims(Integer insuranceClaims) {
        this.insuranceClaims = insuranceClaims;
    }

    public List<Quote> getInsuranceQuotes() {
        return insuranceQuotes;
    }

    public void setInsuranceQuotes(List<Quote> insuranceQuotes) {
        this.insuranceQuotes = insuranceQuotes;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "licenseNo='" + licenseNo + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", experience=" + experience +
                ", faults=" + faults +
                ", vehicleAge=" + vehicleAge +
                ", vehiclePurchasePrice=" + vehiclePurchasePrice +
                ", vehicleAnnualMileage=" + vehicleAnnualMileage +
                ", insuranceCount=" + insuranceCount +
                ", insuranceClaims=" + insuranceClaims +
                ", insuranceQuotes=" + insuranceQuotes +
                '}';
    }
}

