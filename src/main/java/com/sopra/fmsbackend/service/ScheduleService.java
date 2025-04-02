package com.sopra.fmsbackend.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.fmsbackend.exception.ResourceNotFoundException;
import com.sopra.fmsbackend.model.Schedule;
import com.sopra.fmsbackend.repository.ScheduleRepository;


@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository repository;
    private static final Logger log = LoggerFactory.getLogger(ScheduleService.class);

    public List <Schedule> getAllSchedules(){
        return repository.findAll();
    }

    public Schedule getSchedule(Long id){

        log.debug("inside getSchedule");
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Schedule not found with id: " + id));
        
    }

    public Schedule saveSchedule(Schedule Schedule) {

        return repository.save(Schedule);
    }

    public void deleteSchedule(Long id) {
        
        repository.deleteById(id);
    }
    
}
