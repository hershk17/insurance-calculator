package com.example.insurancerestservice.controller;

import com.example.insurancerestservice.repository.QuoteRepository;
import com.example.insurancerestservice.entity.Quote;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/quotes")
public class QuoteController {
    private final QuoteRepository quoteRepository;

    public QuoteController(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quote> getQuoteById(@PathVariable String id) {
        Optional<Quote> quote = quoteRepository.findById(id);
        return quote.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}