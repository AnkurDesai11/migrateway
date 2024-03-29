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
public class DeleteOptions {

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
	
	@JsonProperty("multiUrl")
	private String multiUrl;
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}
