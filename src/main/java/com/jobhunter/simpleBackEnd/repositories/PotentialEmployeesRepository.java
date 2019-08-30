package com.jobhunter.simpleBackEnd.repositories;

import com.jobhunter.simpleBackEnd.models.PotentialEmployees;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PotentialEmployeesRepository extends MongoRepository<PotentialEmployees, String> {
    PotentialEmployees findBy_id(ObjectId _id);
}
