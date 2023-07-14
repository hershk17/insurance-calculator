package com.example.insurancerestservice.service;

import com.example.insurancerestservice.entity.Driver;
import com.example.insurancerestservice.entity.Quote;
import com.example.insurancerestservice.repository.DriverRepository;
import com.example.insurancerestservice.repository.QuoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsuranceService {
    private final DriverRepository driverRepository;
    private final QuoteRepository quoteRepository;

    public InsuranceService(DriverRepository driverRepository, QuoteRepository quoteRepository) {
        this.driverRepository = driverRepository;
        this.quoteRepository = quoteRepository;
    }

    public Optional<Driver> getDriverByLicenseNo(String licenseNo) {
        return driverRepository.findById(licenseNo);
    }

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public Optional<Quote> getQuoteByReference(String reference) {
        return quoteRepository.findById(reference);
    }

    public List<Quote> getQuotesByLicenseNo(String licenseNo) {
        return quoteRepository.findAllByLicenseNo(licenseNo);
    }

    public void saveDriver(Driver driver) {
        driverRepository.save(driver);
    }

    public void saveQuote(Quote quote) {
        quoteRepository.save(quote);
    }
}
