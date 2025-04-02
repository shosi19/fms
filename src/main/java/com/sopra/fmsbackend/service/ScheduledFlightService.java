package com.sopra.fmsbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.fmsbackend.exception.ResourceNotFoundException;
import com.sopra.fmsbackend.model.ScheduledFlight;
import com.sopra.fmsbackend.repository.ScheduledFlightRepository;

import java.util.List;

@Service
public class ScheduledFlightService {
    @Autowired
    private ScheduledFlightRepository scheduledFlightRepository;

    public List<ScheduledFlight> getAllScheduledFlights() {
        return scheduledFlightRepository.findAll();
    }

    public ScheduledFlight getScheduledFlightById(Long id) {
        return scheduledFlightRepository.findById(id).orElse(null);
    }

    public ScheduledFlight saveScheduledFlight(ScheduledFlight scheduledFlight) {
        return scheduledFlightRepository.save(scheduledFlight);
    }

    public void deleteScheduledFlight(Long id) {
        scheduledFlightRepository.deleteById(id);
    }
}
