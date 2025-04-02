package com.sopra.fmsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sopra.fmsbackend.model.ScheduledFlight;

public interface ScheduledFlightRepository extends JpaRepository<ScheduledFlight, Long> {
}
