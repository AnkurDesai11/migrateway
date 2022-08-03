package com.migrateway.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.migrateway.model.Database;
import com.migrateway.repo.DatabaseRepository;
import com.migrateway.service.DatabaseService;

@Service
public class DatabaseServiceImpl implements DatabaseService{

	@Autowired
	private DatabaseRepository databaseRepository;
	
	@Override
	public Database getDatabase(String name) throws Exception {
		return this.databaseRepository.findByName(name);
	}

	@Override
	public List<Database> getAllDatabases() {
		return this.databaseRepository.findAll();
	}

}
