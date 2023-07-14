package com.example.insurancerestservice.Quote;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> { }
//public interface QuoteRepository extends CrudRepository<Quote, Long> {}