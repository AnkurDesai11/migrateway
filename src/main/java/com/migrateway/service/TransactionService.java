package com.migrateway.service;

import java.time.LocalDateTime;

import com.migrateway.dto.PagedTransactionResponse;
import com.migrateway.model.Transaction;

public interface TransactionService {

	public boolean saveTransaction(Transaction transaction);
	
	public PagedTransactionResponse getTransactions(String migrationId, LocalDateTime startTime, LocalDateTime endTime, int pageNumber);
	
}
