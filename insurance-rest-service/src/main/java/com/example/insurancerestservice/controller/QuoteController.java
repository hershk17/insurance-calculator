package com.example.insurancerestservice.Quote;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public ResponseEntity<Quote> getQuoteById(@PathVariable Long id) {
        Optional<Quote> quote = quoteRepository.findById(id);
        return quote.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}