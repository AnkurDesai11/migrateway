package com.migrateway.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.migrateway.model.Log;

public interface LogRepository extends MongoRepository<Log, String>{

	
	
}
