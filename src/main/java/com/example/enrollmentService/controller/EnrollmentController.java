package com.example.enrollmentService.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.enrollmentService.model.Dependent;
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

    //Add single Enrollee at a time
    @PostMapping(value = "/addOrUpdateEnrollee")
    public ResponseEntity<?> saveOrUpdateEnrollee(@RequestBody Enrollee enrollee) {
        enrollmentService.saveOrUpdateEnrollee(enrollee);
        return new ResponseEntity("Enrollee added/updated successfully", HttpStatus.OK);
    }

    //Delete single Enrollee at a time
    @DeleteMapping(value = "/deleteEnrollee/{id}")
    public ResponseEntity<?> deleteEnrollee(@PathVariable("id") String id) {
        enrollmentService.deleteEnrollee(id);
        return new ResponseEntity("Enrollee deleted successfully", HttpStatus.OK);
    }

    //Requires enrolleeId: "", Dependent: dependentObject
    @PostMapping(value = "/addOrUpdateDependent")
    public ResponseEntity<?> saveOrUpdateDependents(@RequestBody String requestBody) {
        enrollmentService.saveOrUpdateDependents(requestBody);
        return new ResponseEntity("Dependent added/updated successfully", HttpStatus.OK);
    }

    //Requires enrolleeId: "", dependentId: ""
    @PostMapping(value = "/deleteDependent")
    public ResponseEntity<?> deleteDependent(@RequestBody String requestBody) {
        enrollmentService.deleteDependent(requestBody);
        return new ResponseEntity("Dependent deleted successfully", HttpStatus.OK);
    }


}
