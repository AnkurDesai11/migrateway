package com.migrateway.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	
	@NotEmpty(message = "Destination database not specified")
	private String destination;
	
	@NotEmpty(message = "Source database not specified")
	private String source;
	
	private boolean migrateAll;
	
	private List<String> toMigrate;
	
	private int pagination;
	
	
	
}
