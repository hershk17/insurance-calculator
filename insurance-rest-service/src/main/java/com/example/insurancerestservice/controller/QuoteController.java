package com.example.insurancerestservice.controller;

import com.example.insurancerestservice.entity.Quote;
import com.example.insurancerestservice.service.InsuranceService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
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
}