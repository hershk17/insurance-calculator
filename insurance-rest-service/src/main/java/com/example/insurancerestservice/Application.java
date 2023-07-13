package com.example.insurancerestservice;

import com.example.insurancerestservice.driver.Driver;
import com.example.insurancerestservice.driver.DriverRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class InsuranceRestServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InsuranceRestServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner init(DriverRepository driverRepository) {
        return args -> {
            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
                Driver driver = new Driver(name);
                driverRepository.save(driver);
            });
            driverRepository.findAll().forEach(System.out::println);
        };
    }
}
