package com.migrateway.prodcon;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;

import com.migrateway.dto.DataDto;
import com.migrateway.model.MigrationLog;
import com.migrateway.service.MigrationLogService;
import com.migrateway.service.TransactionService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MigrationProcess {

	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private MigrationLogService migrationLogService;
	
	private WebClient webClient;
	
	private String id;
	
	BlockingQueue<DataDto> toProcessQueue;//= new LinkedBlockingQueue();
	
	private int processedCounter;
	
	private boolean poisonPill;
	
	private boolean allPaginated;
	
	public MigrationLog getFromSource() {
		
		
		return null;
		
	}
	
	public MigrationLog postToDestination() {
		/*
		do {
			try {
				
			} catch (InterruptedException ex) {
				this.migrationLogService.saveMigrationLog(new MigrationLog (this.id, "ERROR",))
			}
		}while( ! ( poisonPill && this.toProcessQueue.isEmpty() ) );*/
		return null;
		
	}
	
	
	
}
