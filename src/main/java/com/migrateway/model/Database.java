package com.migrateway.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
	private Integer id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("baseUrl")
	private String baseUrl;
	
	@JsonProperty("healthCheck")
	private String healthCheck;
	
	@JsonProperty("mask")
	private String mask;
	
	@JsonProperty("readOptions")
	ReadOptions readOptions = new ReadOptions();
	
	@JsonProperty("writeOptions")
	WriteOptions writeOptions = new WriteOptions();
	
	@JsonProperty("updateOptions")
	UpdateOptions updateOptions = new UpdateOptions();
	
	@JsonProperty("deleteOptions")
	DeleteOptions deleteOptions = new DeleteOptions();
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
};


	
