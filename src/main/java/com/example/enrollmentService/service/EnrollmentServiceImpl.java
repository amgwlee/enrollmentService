package com.example.enrollmentService.service;

import com.example.enrollmentService.component.DependentComponent;
import com.example.enrollmentService.model.Dependent;
import com.example.enrollmentService.model.Enrollee;
import com.example.enrollmentService.model.EnrollmentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private DependentComponent dependentComponent;

    ObjectMapper objectMapper = new ObjectMapper();

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

    @Override
    public void saveOrUpdateDependent(String requestBody) {

        Optional<Enrollee> foundEnrollee = null;
        Dependent dependent = null;
        JsonNode jsonNode;
        JsonNode dependentJson;
        String enrolleeId = null;

        try {
            jsonNode = objectMapper.readValue(requestBody, JsonNode.class);

            //get enrolleeId
            enrolleeId = jsonNode.get("enrolleeId").asText();

            //get dependent data
            dependentJson = jsonNode.get("dependent");
            String dependentId = dependentJson.get("id").asText();
            String dFirstName = dependentJson.get("firstName").asText();
            String dLastName = dependentJson.get("lastName").asText();
            String bDayString = dependentJson.get("birthDate").asText();
            Date dBirthDate = new SimpleDateFormat("yyyy-MM-dd").parse(bDayString);

            //build dependent
            dependent = new Dependent(dependentId, dFirstName, dLastName, dBirthDate);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if(enrolleeId != null || enrolleeId.isEmpty())
            foundEnrollee = findById(enrolleeId);

        //ensure valid enrollee and dependent are found before updating
        if(foundEnrollee.isPresent() && dependent != null) {
            Enrollee enrollee = dependentComponent.saveOrUpdateDependent(foundEnrollee.get(), dependent);

            saveOrUpdateEnrollee(enrollee);
        } else {
            return;
        }

    }

    @Override
    public void deleteDependent(String requestBody) {
        JsonNode jsonNode;
        String enrolleeId = null;
        String dependentId = null;
        Optional<Enrollee> foundEnrollee = null;

        try {
            jsonNode = objectMapper.readValue(requestBody, JsonNode.class);

            //get Ids
            enrolleeId = jsonNode.get("enrolleeId").asText();
            dependentId = jsonNode.get("dependentId").asText();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        if(enrolleeId != null || enrolleeId.isEmpty())
            foundEnrollee = findById(enrolleeId);

        //ensure valid enrollee is found before updating
        if(foundEnrollee.isPresent()) {
            Enrollee enrollee = dependentComponent.deleteDependent(foundEnrollee.get(), dependentId);

            saveOrUpdateEnrollee(enrollee);

        } else {
            return;
        }
    }
}
