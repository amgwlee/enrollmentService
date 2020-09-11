package com.example.enrollmentService.controller;

import java.util.List;
import java.util.Optional;

import com.example.enrollmentService.model.Enrollee;
import com.example.enrollmentService.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enrollees")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;


    @GetMapping("/")
    public List<Enrollee> getAllEnrollees() {
        return enrollmentService.findAll();
    }

    @GetMapping(value = "/byEnrolleeId/{id}")
    public Optional<Enrollee> getEnrolleeById(@PathVariable("id") String id) {
        return enrollmentService.findById(id);
    }

    @GetMapping(value = "/byLastName/{lastName}")
    public List<Enrollee> getEnrolleesByLastName(@PathVariable("lastName") String lastName) {
        return enrollmentService.findByLastName(lastName);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveOrUpdateEnrollee(@RequestBody Enrollee enrollee) {
        enrollmentService.saveOrUpdateEnrollee(enrollee);
        return new ResponseEntity("Enrollee added successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteEnrollee(@PathVariable("id") String id) {
        enrollmentService.deleteEnrollee(id);
    }


}
