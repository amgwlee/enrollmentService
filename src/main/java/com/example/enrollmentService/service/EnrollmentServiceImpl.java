package com.example.enrollmentService.service;

import com.example.enrollmentService.model.Enrollee;
import com.example.enrollmentService.model.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Override
    public List<Enrollee> findAll() {
        return enrollmentRepository.findAll();
    }

    @Override
    public Optional<Enrollee> findById(String id) {
        return enrollmentRepository.findById(id);
    }

    @Override
    public List<Enrollee> findByLastName(String lastName) {
        return enrollmentRepository.findByLastName(lastName);
    }

    @Override
    public void saveOrUpdateEnrollee(Enrollee enrollee) {
        enrollmentRepository.save(enrollee);
    }

    @Override
    public void deleteEnrollee(String id) {
        enrollmentRepository.deleteById(id);
    }

//    @Override
//    public void saveOrUpdateDependents(String enrolleeId, Dependent dependent) {
//
//    }
//
//    @Override
//    public void deleteDependents(String id) {
//
//    }
}
