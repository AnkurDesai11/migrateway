package com.migrateway.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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
@JsonIgnoreProperties(ignoreUnknown = true)
public class MigrationRequestDto {
	
	@JsonProperty("destination")
	@NotEmpty(message = "Destination database not specified")
	private String destination;
	
	@JsonProperty("source")
	@NotEmpty(message = "Source database not specified")
	private String source;
	
	@JsonProperty("migrateAll")
	private boolean migrateAll;
	
	@JsonProperty("toMigrate")
	private ArrayList<String> toMigrate;
	
	@JsonProperty("pagination")
	private int pagination;
	
	
	
}
