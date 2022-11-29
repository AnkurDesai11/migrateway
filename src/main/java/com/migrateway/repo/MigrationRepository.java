package com.migrateway.repo;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.migrateway.model.Migration;

public interface MigrationRepository extends MongoRepository<Migration, String>{
	
	@Query("{ '$or': [ {'startTimestamp' : {$lte : ?1, $gte : ?0}}, {'endTimestamp' : {$lte : ?1, $gte : ?0}} ] }")
	public Page<Migration> findByTime(LocalDateTime startTime, LocalDateTime endTime, Pageable pageInfo);
	
	public Page<Migration> findBySourceAndDestination(String source, String destination, Pageable pageInfo);
	
	public Page<Migration> findBySource(String source, Pageable pageInfo);
	
	public Page<Migration> findByDestination(String destination, Pageable pageInfo);
	
}
