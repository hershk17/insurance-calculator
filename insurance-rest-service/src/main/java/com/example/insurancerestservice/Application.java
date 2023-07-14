package com.example.insurancerestservice;

import com.example.insurancerestservice.entity.Driver;
import com.example.insurancerestservice.entity.Quote;
import com.example.insurancerestservice.repository.DriverRepository;
import com.example.insurancerestservice.repository.QuoteRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Stream;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean(name = "driverInit")
    CommandLineRunner driverInit(DriverRepository driverRepository) {
        return args -> {
            Stream.of("John", "Julie", "Jennifer").forEach(name -> {
                Driver driver = new Driver();
                driver.setName(name);
                driverRepository.save(driver);
            });
            driverRepository.findAll().forEach(System.out::println);
        };
    }

    @Bean(name = "quoteInit")
    CommandLineRunner quoteInit(QuoteRepository quoteRepository) {
        return args -> {
            Stream.of(1200.0, 1800.0, 2000.0).forEach(premium -> {
                Quote quote = new Quote();
                quote.setPremium(premium);
                quoteRepository.save(quote);
            });
            quoteRepository.findAll().forEach(System.out::println);
        };
    }
}
