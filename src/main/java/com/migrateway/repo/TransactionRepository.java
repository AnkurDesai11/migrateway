package com.migrateway.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.migrateway.model.Transaction;

public interface TransactionRepository extends MongoRepository<Transaction, String>{

	
	
}

