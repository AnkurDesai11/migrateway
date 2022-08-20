package com.migrateway.service;

import com.migrateway.model.OperationsQueue;

public interface QueueService {
	
	public OperationsQueue getQueue() throws Exception;
	
	public OperationsQueue updateQueue(OperationsQueue queue);
	
	public boolean isQueueFull(OperationsQueue queue);
	
	public boolean isinQueue(OperationsQueue queue, String queueClass, String dbName);
	
}
