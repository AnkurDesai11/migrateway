package com.migrateway.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Document(collection = "logs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Log {

	@Id
	private String id;
	
	private String migrationId;
	
	private String type;
	
	private LocalDateTime timestamp;
	
	private String message;
	
}
