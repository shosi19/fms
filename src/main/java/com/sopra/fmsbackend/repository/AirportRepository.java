package com.sopra.fmsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sopra.fmsbackend.model.Airport;


public interface AirportRepository extends JpaRepository<Airport, Long>{
    
	
}
