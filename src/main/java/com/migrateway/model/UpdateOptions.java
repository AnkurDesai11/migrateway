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
public class UpdateOptions {

	@JsonProperty("singleUrl")
	private String singleUrl; 
	
	@JsonProperty("method")
	private String method;
	
	@JsonProperty("singleBodyType")
	private String singleBodyType;
	
	@JsonProperty("multiBody")
	private String multiBody;
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}
