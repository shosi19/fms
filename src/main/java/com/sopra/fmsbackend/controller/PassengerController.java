package com.sopra.fmsbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.fmsbackend.model.Passenger;
import com.sopra.fmsbackend.service.PassengerService;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {

    @Autowired
    private PassengerService PassengerService;

    @GetMapping
    public List<Passenger> getAllPassengers() {
        return PassengerService.getAllPassengers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPassengerById(@PathVariable Long id) {
        Passenger Passenger = PassengerService.getPassenger(id);
        return ResponseEntity.ok(Passenger);
        
    }

    @PostMapping
    public Passenger createPassenger(@RequestBody Passenger Passenger) {
        return PassengerService.savePassenger(Passenger);
    }

    @PutMapping("/{id}")
    public Passenger updatePassenger(@PathVariable Long id, @RequestBody Passenger Passenger) {
        Passenger.setId(id);
        return PassengerService.savePassenger(Passenger);
    }

    @DeleteMapping("/{id}")
    public void deletePassenger(@PathVariable Long id) {
        PassengerService.deletePassenger(id);
    }
    
}
