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
public class MultiReadOptions {
	
	@JsonProperty("pagesize")
	private String pagesize;
	@JsonProperty("pagenumber")
	private String pagenumber;
	@JsonProperty("sortfield")
	private String sortfield;
	@JsonProperty("sortorder")
	private String sortorder;
	@JsonProperty("searchfield")
	private String searchfield;
	@JsonProperty("searchkeyword")
	private String searchkeyword;
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
}
