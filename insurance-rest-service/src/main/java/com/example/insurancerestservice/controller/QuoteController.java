package com.example.insurancerestservice.controller;

import com.example.insurancerestservice.entity.Quote;
import com.example.insurancerestservice.service.InsuranceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/quotes")
public class QuoteController {
    private final InsuranceService insuranceService;

    public QuoteController(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    @GetMapping(params = "reference")
    public Optional<Quote> getQuoteByReference(@RequestParam(name="reference") String value) {
        return insuranceService.getQuoteByReference(value);
    }

    @GetMapping(params = "licenseNo")
    public List<Quote> getQuotesByLicenseNo(@RequestParam(name="licenseNo") String value) {
        return insuranceService.getQuotesByLicenseNo(value);
    }
}