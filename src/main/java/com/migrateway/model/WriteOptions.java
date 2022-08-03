package com.migrateway.model;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class WriteOptions {
	
	private String singleUrl;
	private String method;
	private String multiBody;
	private String multiUrl;
	
	MultiWriteOptions writeOptions = new MultiWriteOptions();
	
}
