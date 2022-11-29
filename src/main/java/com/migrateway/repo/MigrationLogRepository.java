package com.migrateway.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.migrateway.model.MigrationLog;

public interface MigrationLogRepository extends MongoRepository<MigrationLog, String>{

	
	
}
