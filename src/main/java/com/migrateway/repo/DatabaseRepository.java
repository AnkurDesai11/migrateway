package com.migrateway.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.migrateway.model.Database;

public interface DatabaseRepository extends MongoRepository<Database, Integer>{

	public Database findByName(String name);
	
}
