package com.jobhunter.simpleBackEnd.repositories;

import com.jobhunter.simpleBackEnd.models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {
	Role findByRole(String role);
}
