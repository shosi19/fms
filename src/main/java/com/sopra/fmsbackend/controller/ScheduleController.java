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

import com.sopra.fmsbackend.model.Schedule;
import com.sopra.fmsbackend.service.ScheduleService;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

    @Autowired
   private ScheduleService service;

   @GetMapping
   public List<Schedule> getAllSchedules() {
       return service.getAllSchedules();
   }

   @GetMapping("/{id}")
   public ResponseEntity<Object> getFlightById(@PathVariable Long id) {
       Schedule Schedule = service.getSchedule(id);
       return ResponseEntity.ok(Schedule);
       
   }

   @PostMapping
   public Schedule createFlight(@RequestBody Schedule Schedule) {
       return service.saveSchedule(Schedule);
   }

   @PutMapping("/{id}")
   public Schedule updateFlight(@PathVariable Long id, @RequestBody Schedule Schedule) {
       Schedule.setId(id);
       return service.saveSchedule(Schedule);
   }

   @DeleteMapping("/{id}")
   public void deleteFlight(@PathVariable Long id) {
       service.deleteSchedule(id);
   }
   
}
