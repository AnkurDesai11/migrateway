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
public class ReadOptions {
	
	@JsonProperty("singleUrl")
	private String singleUrl; 
	
	@JsonProperty("method")
	private String method;
	
	//can be url, query, header, body 
	@JsonProperty("idLocation")
	private String idLocation;
	
	//{{value}} for url, else key name to use in query, header , body
	@JsonProperty("idKey")
	private String idKey; 
	
	@JsonProperty("paginated")
	private boolean paginated;
	
	@JsonProperty("paginationType")
	private String paginationType;
	
	@JsonProperty("maxPageSize")
	private int maxPageSize;
	
	@JsonProperty("multiUrl")
	private String multiUrl;
	
	//can be query, header, or link(will have to next link in received object reponse)
	@JsonProperty("multiReadOptionsLocation")
	private String multiReadOptionsLocation;

	@JsonProperty("multiReadOptions")
	MultiReadOptions multiReadOptions = new MultiReadOptions();
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
}
