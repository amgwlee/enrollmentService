package com.example.enrollmentService.model;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "enrollees", path = "enrollees")
public interface EnrollmentRepository extends MongoRepository<Enrollee, String> {

    Optional<Enrollee> findById(@Param("name") String id);

    List<Enrollee> findByLastName(@Param("name") String lastName);


}
