package com.jobhunter.simpleBackEnd.repositories;

import com.jobhunter.simpleBackEnd.models.Employers;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployersRepository extends MongoRepository<Employers, String> {
    Employers findBy_id(ObjectId _id);
}
