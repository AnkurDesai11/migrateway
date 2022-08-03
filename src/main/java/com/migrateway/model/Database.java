package com.migrateway.model;
import java.util.Date;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Document(collection = "databases")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Database {
	
	@Id
	private int id;
	private String name;
	private String baseUrl;
	private String healthCheck;
	
	ReadOptions readOptions = new ReadOptions();
	
	WriteOptions writeOptions = new WriteOptions();
	
};


	
