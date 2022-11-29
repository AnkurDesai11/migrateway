package com.migrateway.model;

import java.util.HashMap;
import java.util.Queue;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Document(collection = "queue")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationsQueue {

	@Id
	private Integer id;
	
	private int currentQueueSize;
	
	private Queue<HashMap<String, String>> queueValues;
	
}
