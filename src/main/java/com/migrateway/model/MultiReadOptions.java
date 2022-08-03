package com.migrateway.model;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class MultiReadOptions {
	
	private String pageSize;
	private String pageNumber;
	private String sortField;
	private String sortOrder;
	private String searchField;
	private String searchKeyword;
	
}
