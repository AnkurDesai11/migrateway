package com.migrateway.model;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Document(collection = "transactions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

	@Id
	private String id;
	
	private String migrationId;
	
	private String uId;
	
	private String source;
	
	private String destination;
	
	private String outcome;
	
	private String info;
	
}
