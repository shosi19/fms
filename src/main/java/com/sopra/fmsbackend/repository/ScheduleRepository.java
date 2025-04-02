package com.sopra.fmsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sopra.fmsbackend.model.Schedule;


public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    
}
