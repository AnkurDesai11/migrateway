package com.migrateway.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MultiWriteOptions {

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}
