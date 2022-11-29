package com.migrateway.service.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.migrateway.dto.PagedMigrationResponse;
import com.migrateway.model.Migration;
import com.migrateway.service.MigrationService;

@Service
public class MigrationServiceImpl implements MigrationService {

	@Override
	public boolean saveTransaction(Migration migration) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PagedMigrationResponse getTransactions(String source, String destination, LocalDateTime startTime,
			LocalDateTime endTime) {
		// TODO Auto-generated method stub
		return null;
	}

}
