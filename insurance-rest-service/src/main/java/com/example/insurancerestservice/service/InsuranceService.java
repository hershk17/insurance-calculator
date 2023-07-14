package com.example.insurancerestservice.service;

import com.example.insurancerestservice.entity.Driver;
import com.example.insurancerestservice.entity.Quote;
import com.example.insurancerestservice.repository.DriverRepository;
import com.example.insurancerestservice.repository.QuoteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DriverService {
    private final DriverRepository driverRepository;
    private final QuoteRepository quoteRepository;

    public DriverService(DriverRepository driverRepository, QuoteRepository quoteRepository) {
        this.driverRepository = driverRepository;
        this.quoteRepository = quoteRepository;
    }

    public Quote saveQuote(Long driverId, Quote quote) {
        Optional<Driver> optionalDriver = driverRepository.findById(driverId);
        if (optionalDriver.isPresent()) {
            Driver driver = optionalDriver.get();
            quote.setDriver(driver); // Associate the quote with the driver

            return quoteRepository.save(quote);
        }
        return null;
    }

    // Other service methods
}
