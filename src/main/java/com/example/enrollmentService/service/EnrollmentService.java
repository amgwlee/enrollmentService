package com.example.enrollmentService.service;

import com.example.enrollmentService.model.Enrollee;

import java.util.List;
import java.util.Optional;

public interface EnrollmentService {

    List<Enrollee> findAll();

    Optional<Enrollee> findById(String id);

    List<Enrollee> findByLastName(String lastName);

    void saveOrUpdateEnrollee(Enrollee enrollee);

    void deleteEnrollee(String id);

//    void saveOrUpdateDependents(String enrolleeId, Dependent dependent);
//
//    void deleteDependents(String id);

}
