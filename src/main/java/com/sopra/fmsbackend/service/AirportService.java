package com.sopra.fmsbackend.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sopra.fmsbackend.exception.ResourceNotFoundException;
import com.sopra.fmsbackend.model.Airport;
import com.sopra.fmsbackend.model.CommonApiResponse;
import com.sopra.fmsbackend.repository.AirportRepository;

@Service
public class AirportService {

    @Autowired
    private AirportRepository repository;
    private static final Logger log = LoggerFactory.getLogger(AirportService.class);


    public List<Airport> getAllAirports() {
        
        return repository.findAll();
    }

    public Airport getAirport(Long id) {
        
        log.debug("inside getAirport service");
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Airport not found with id: " + id));
        
    }

    public Airport saveAirport(Airport airport) {
        log.debug("inside saveAirport service method, Input:" + airport.toString());
        return repository.save(airport);
    }

    
    public void deleteAirport(Long id) {
       
         repository.deleteById(id);
    }
    
}
