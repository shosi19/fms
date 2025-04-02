package com.sopra.fmsbackend.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.fmsbackend.exception.ResourceNotFoundException;
import com.sopra.fmsbackend.model.Passenger;
import com.sopra.fmsbackend.repository.PassengerRepository;

@Service
public class PassengerService {

    
    @Autowired
    private PassengerRepository repository;
    private static final Logger log = LoggerFactory.getLogger(PassengerService.class);

    public List <Passenger> getAllPassengers(){
        return repository.findAll();
    }

    public Passenger getPassenger(Long id){

        log.debug("inside getPassenger");
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Passenger not found with id: " + id));
        
    }

    public Passenger savePassenger(Passenger Passenger) {

        return repository.save(Passenger);
    }

    public void deletePassenger(Long id) {
        
        repository.deleteById(id);
    }
    
}
