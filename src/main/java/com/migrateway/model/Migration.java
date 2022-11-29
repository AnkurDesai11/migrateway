package com.migrateway.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Document(collection = "migrations")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Migration {
	
	@Id
	private String migrationId;
	
	private String source;
	
	private String destination;
	
	private LocalDateTime startTimestamp;
	
	private LocalDateTime endTimestamp;
	
	private Integer totalProcessed;
	
	private Integer succeeded;
	
	private Integer failed;
	
}
