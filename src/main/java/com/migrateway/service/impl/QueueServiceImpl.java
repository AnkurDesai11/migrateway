package com.migrateway.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.migrateway.config.AppConstants;
import com.migrateway.model.OperationsQueue;
import com.migrateway.repo.QueueRepository;
import com.migrateway.service.QueueService;

@Service
public class QueueServiceImpl implements QueueService{

	@Autowired
	private QueueRepository queueRepository;
	
	@Override
	public OperationsQueue getQueue()  throws Exception{
		return this.queueRepository.findById(AppConstants.QUEUE_ID).orElseThrow(RuntimeException::new);
	}

	@Override
	public OperationsQueue updateQueue(OperationsQueue queue) {
		return this.queueRepository.save(queue);
	}

	@Override
	public boolean isQueueFull(OperationsQueue queue) {
		return (queue.getCurrentQueueSize()>=AppConstants.QUEUE_SIZE);
	}

	@Override
	public boolean isinQueue(OperationsQueue queue, String queueClass, String dbName) {
		if (queueClass.equals(AppConstants.READ_QUEUE))
			return queue.getReadQueue().contains(dbName);
		else
			return queue.getWriteQueue().contains(dbName);
	}

}
