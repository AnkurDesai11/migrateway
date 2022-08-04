package com.migrateway.model;
import java.util.Date;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

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
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("baseUrl")
	private String baseUrl;
	
	@JsonProperty("healthCheck")
	private String healthCheck;
	
	@JsonProperty("readOptions")
	ReadOptions readOptions = new ReadOptions();
	
	@JsonProperty("writeOptions")
	WriteOptions writeOptions = new WriteOptions();
	
};


	
