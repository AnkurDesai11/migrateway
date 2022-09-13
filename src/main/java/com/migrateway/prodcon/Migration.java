package com.migrateway.prodcon;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.migrateway.dto.DataDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Migration {

	private String id;
	
	BlockingQueue<DataDto> toProcessQueue;//= new LinkedBlockingQueue();
	
	private int processedCounter;
	
	private boolean poisonPill;
	
	private boolean allPaginated;
	
	
	
}
