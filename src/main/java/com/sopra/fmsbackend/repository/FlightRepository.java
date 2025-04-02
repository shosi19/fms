package com.sopra.fmsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sopra.fmsbackend.model.Flight;


public interface FlightRepository extends JpaRepository<Flight, Long> {

  
}
