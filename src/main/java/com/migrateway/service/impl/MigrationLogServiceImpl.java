package com.migrateway.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.migrateway.model.MigrationLog;
import com.migrateway.repo.MigrationLogRepository;
import com.migrateway.service.MigrationLogService;

@Service
public class MigrationLogServiceImpl implements MigrationLogService{

	@Autowired
	private MigrationLogRepository migrationLogRepository;

	@Override
	public boolean saveMigrationLog(MigrationLog migrationLog) {
		try {
			return this.migrationLogRepository.save(migrationLog) != null;
		}catch(Exception e) {
			return false;
		}
		
	}
	
}
