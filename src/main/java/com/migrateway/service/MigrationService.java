package com.migrateway.service;

import java.time.LocalDateTime;

import com.migrateway.dto.PagedMigrationResponse;
import com.migrateway.model.Migration;

public interface MigrationService {

	public boolean saveTransaction(Migration migration);
	
	public PagedMigrationResponse getTransactions(String source, String destination, LocalDateTime startTime, LocalDateTime endTime);
	
}
