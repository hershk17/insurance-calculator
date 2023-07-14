package com.example.insurancerestservice.driver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
//public interface DriverRepository extends CrudRepository<Driver, Long> {}

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
}
