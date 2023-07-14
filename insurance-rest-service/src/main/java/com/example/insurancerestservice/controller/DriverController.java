package com.example.insurancerestservice.controller;

import com.example.insurancerestservice.entity.Driver;
import com.example.insurancerestservice.entity.Quote;
import com.example.insurancerestservice.service.InsuranceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DriverController {
    private final InsuranceService insuranceService;

    public DriverController(InsuranceService driverService) {
        this.insuranceService = driverService;
    }

    @GetMapping("/drivers")
    public List<Driver> getDrivers() {
        return insuranceService.getAllDrivers();
    }

    @PostMapping("/calculate")
    public Quote calculateInsurance(@RequestBody Driver driver) {
        return insuranceService.getNewInsuranceQuote(driver);
    }
}