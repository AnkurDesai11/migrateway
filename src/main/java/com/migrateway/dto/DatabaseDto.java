package com.migrateway.dto;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.migrateway.model.DeleteOptions;
import com.migrateway.model.ReadOptions;
import com.migrateway.model.UpdateOptions;
import com.migrateway.model.WriteOptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DatabaseDto {
	
	@NotEmpty(message = "Database name not specified")
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("healthCheck")
	private String healthCheck;
	
	@NotEmpty(message = "Mask url not specified")
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
	
}
