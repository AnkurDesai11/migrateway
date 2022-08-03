package com.migrateway.service;

import java.util.List;

import com.migrateway.model.Database;

public interface DatabaseService {
	
	public Database getDatabase(String name) throws Exception;
	
	public List<Database> getAllDatabases();
}
