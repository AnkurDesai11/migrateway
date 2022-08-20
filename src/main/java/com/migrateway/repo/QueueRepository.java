package com.migrateway.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.migrateway.model.OperationsQueue;

public interface QueueRepository extends MongoRepository<OperationsQueue, Integer>{
	
}
