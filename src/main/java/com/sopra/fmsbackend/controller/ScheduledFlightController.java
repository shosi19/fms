package com.sopra.fmsbackend.controller;

import com.sopra.fmsbackend.model.ScheduledFlight;
import com.sopra.fmsbackend.service.ScheduledFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scheduledFlights")
public class ScheduledFlightController {
    @Autowired
    private ScheduledFlightService scheduledFlightService;

    @GetMapping
    public List<ScheduledFlight> getAllScheduledFlights() {
        return scheduledFlightService.getAllScheduledFlights();
    }

    @GetMapping("/{id}")
    public ScheduledFlight getScheduledFlightById(@PathVariable Long id) {
        return scheduledFlightService.getScheduledFlightById(id);
    }

    @PostMapping
    public ScheduledFlight createScheduledFlight(@RequestBody ScheduledFlight scheduledFlight) {
        return scheduledFlightService.saveScheduledFlight(scheduledFlight);
    }

    @PutMapping("/{id}")
    public ScheduledFlight updateScheduledFlight(@PathVariable Long id, @RequestBody ScheduledFlight scheduledFlight) {
        scheduledFlight.setId(id);
        return scheduledFlightService.saveScheduledFlight(scheduledFlight);
    }

    @DeleteMapping("/{id}")
    public void deleteScheduledFlight(@PathVariable Long id) {
        scheduledFlightService.deleteScheduledFlight(id);
    }
}
