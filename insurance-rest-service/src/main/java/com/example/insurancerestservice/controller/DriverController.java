package com.example.insurancerestservice.controller;

import com.example.insurancerestservice.entity.Driver;
import com.example.insurancerestservice.service.InsuranceService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DriverController {
    private final InsuranceService insuranceService;

    public DriverController(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    @PostMapping("/calculate")
    public String calculateInsurance(@RequestBody Driver driver) {
        return insuranceService.createQuote(driver).getReference();
    }
}