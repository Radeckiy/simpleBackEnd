package com.jobhunter.simpleBackEnd.repositories;

import com.jobhunter.simpleBackEnd.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
	User findByEmail(String email);
}
