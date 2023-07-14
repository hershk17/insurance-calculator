package com.example.insurancerestservice.service;

import com.example.insurancerestservice.entity.Driver;
import com.example.insurancerestservice.entity.Quote;
import com.example.insurancerestservice.repository.DriverRepository;
import com.example.insurancerestservice.repository.QuoteRepository;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class InsuranceService {
    private final RestTemplate restTemplate;

    private final DriverRepository driverRepository;
    private final QuoteRepository quoteRepository;

    public InsuranceService(RestTemplate restTemplate, DriverRepository driverRepository, QuoteRepository quoteRepository) {
        this.restTemplate = restTemplate;
        this.driverRepository = driverRepository;
        this.quoteRepository = quoteRepository;
    }

    public Optional<Quote> getQuoteByReference(String reference) {
        return quoteRepository.findById(reference);
    }

    public List<Quote> getQuotesByLicenseNo(String licenseNo) {
        return quoteRepository.findAllByLicenseNo(licenseNo);
    }

    public Quote getNewInsuranceQuote(Driver driver) {
        Quote quote = new Quote();
        quote.setLicenseNo(driver.getLicenseNo());
        quote.setSuccess(true);

        String apiUrl = "https://storage.googleapis.com/connex-th/insurance_assignment/base_premium.json";
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
        Gson gson = new Gson();
        JsonObject jsonObj = gson.fromJson(response.getBody(), JsonObject.class);
        double basePremium = jsonObj.get("base_premium").getAsDouble();

        // calculate age factor
        double ageFactor = 0.0;
        Integer age = driver.getAge();
        if (age < 25) {
            ageFactor = 1.3;
        }
        else if (age < 40) {
            ageFactor = 1;
        }
        else if (age < 70) {
            ageFactor = 0.9;
        }
        else {
            quote.setSuccess(false);
        }

        double drivingExperienceFactor = 0.0;
        Integer drivingExperience = driver.getExperience();
        if (drivingExperience < 2) {
            drivingExperienceFactor = 1.5;
        } else if (drivingExperience < 5) {
            drivingExperienceFactor = 1.3;
        } else if (drivingExperience < 10) {
            drivingExperienceFactor = 1;
        } else {
            drivingExperienceFactor = 0.9;
        }

        double driverRecordFactor = 0.0;
        Integer trafficViolations = driver.getFaults();
        if (trafficViolations == 0) {
            driverRecordFactor = 1;
        } else if (trafficViolations == 1) {
            driverRecordFactor = 1.1;
        } else if (trafficViolations >= 2 && trafficViolations <= 3) {
            driverRecordFactor = 1.3;
        } else {
            quote.setSuccess(false);
        }

        double claimsFactor = 0.0;
        Integer claims = driver.getInsuranceClaims();
        if (claims == 0) {
            claimsFactor = 0.9;
        } else if (claims == 1) {
            claimsFactor = 1.2;
        } else if (claims >= 2 && claims <= 3) {
            claimsFactor = 1.5;
        } else {
            quote.setSuccess(false);
        }

        double carValueFactor = 0.0;
        Double carValue = driver.getVehiclePurchasePrice();
        if (carValue < 30000.0) {
            carValueFactor = 0.8;
        } else if (carValue < 60000.0) {
            carValueFactor = 1;
        } else if (carValue < 100000.0) {
            carValueFactor = 1.2;
        } else if (carValue < 150000.0) {
            carValueFactor = 1.5;
        } else if (carValue < 200000.0) {
            carValueFactor = 2;
        } else {
            quote.setSuccess(false);
        }

        double mileageFactor = 0.0;
        Double annualMileage = driver.getVehicleAnnualMileage();
        if (annualMileage < 20000.0) {
            mileageFactor = 0.9;
        } else if (annualMileage < 30000.0) {
            mileageFactor = 1;
        } else if (annualMileage < 50000.0) {
            mileageFactor = 1.1;
        } else {
            mileageFactor = 1.3;
        }

        double insuranceHistoryFactor = 0.0;
        Integer insuranceHistory = driver.getInsuranceCount();
        if (insuranceHistory == 0) {
            insuranceHistoryFactor = 1.2;
        } else if (insuranceHistory < 2) {
            insuranceHistoryFactor = 1.1;
        } else {
            insuranceHistoryFactor = 1;
        }

        double insuranceFactor = ageFactor * drivingExperienceFactor * driverRecordFactor * claimsFactor *
                carValueFactor * mileageFactor * insuranceHistoryFactor;

        double premium = basePremium * insuranceFactor;
        quote.setPremium(premium);

        driverRepository.save(driver);
        quoteRepository.save(quote);

        return quote;
    }
}
