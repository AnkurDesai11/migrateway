package com.migrateway.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class WriteOptions {
	
	@JsonProperty("singleUrl")
	private String singleUrl;
	
	@JsonProperty("method")
	private String method;
	
	@JsonProperty("multiBody")
	private String multiBody;
	
	@JsonProperty("multiUrl")
	private String multiUrl;
	
	@JsonProperty("writeOptions")
	MultiWriteOptions writeOptions = new MultiWriteOptions();
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
}
