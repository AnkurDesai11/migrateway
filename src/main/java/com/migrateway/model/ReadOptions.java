package com.migrateway.model;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ReadOptions {
	
	private String singleUrl; 
	private String method;
	
	//can be url, query, header, body 
	private String idLocation;
	
	//{{value}} for url, else key name to use in query, header , body
	private String idKey; 
	
	private boolean paginated;
	
	private String multiUrl;
	
	//can be query, header
	private String multiReadOptionsLocation;

	MultiReadOptions multiReadOptions = new MultiReadOptions();
	
}
