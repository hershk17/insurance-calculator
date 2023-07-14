package com.example.insurancerestservice.driver;

import com.example.insurancerestservice.Quote.Quote;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DriverController {
    private final DriverRepository driverRepository;

    public DriverController(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @GetMapping("/drivers")
    public List<Driver> getDrivers() {
        return (List<Driver>) driverRepository.findAll();
    }

    @PostMapping("/calculate")
    public void calculateInsurance(@RequestBody Driver driverInfo) {
        System.out.println(driverInfo);

        driverRepository.save(driverInfo);
    }

    @PostMapping("/{driverId}/quotes")
    public ResponseEntity<Quote> saveQuote(@PathVariable Long driverId, @RequestBody Quote quote) {
        Quote savedQuote = driverService.saveQuote(driverId, quote);
        if (savedQuote != null) {
            return ResponseEntity.ok(savedQuote);
        }
        return ResponseEntity.notFound().build();
    }
}