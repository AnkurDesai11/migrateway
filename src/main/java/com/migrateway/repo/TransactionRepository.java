package com.migrateway.repo;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.migrateway.model.Transaction;

public interface TransactionRepository extends MongoRepository<Transaction, String>{

	@Query("{ 'timestamp' : {$lte : ?1, $gte : ?0} }")
	public Page<Transaction> findByTimestamp(LocalDateTime startTime, LocalDateTime endTime, Pageable pageInfo);
	
	public Page<Transaction> findByMigrationId(String migrationId, Pageable pageInfo);
	
	@Query("{ 'timestamp' : {$lte : ?1, $gte : ?0} , 'migrationId' : ?2 }")
	public Page<Transaction> findByTimestampandMigrationId(LocalDateTime startTime, LocalDateTime endTime, String migrationId, Pageable pageInfo);
	
	public Page<Transaction> findAll(Pageable pageInfo);
	
}

