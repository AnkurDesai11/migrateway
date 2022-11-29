package com.migrateway.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.migrateway.config.AppConstants;
import com.migrateway.dto.PagedTransactionResponse;
import com.migrateway.model.Transaction;
import com.migrateway.repo.TransactionRepository;
import com.migrateway.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;
	
	@Override
	public boolean saveTransaction(Transaction transaction) {
		try {
			return this.transactionRepository.save(transaction) != null;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public PagedTransactionResponse getTransactions(String migrationId, LocalDateTime startTime, LocalDateTime endTime, int pageNumber) {
		
		Pageable pageInfo = PageRequest.of(pageNumber, AppConstants.TRANSACTION_PAGE_SIZE, Sort.by("timestamp").descending());
		Page<Transaction> pagedTransactions = null;
		System.out.println(startTime+" "+endTime+" "+migrationId);
		//String op = "";
		
		if( migrationId.equals("") || migrationId==null) {
			if (startTime==null && endTime==null) {
				pagedTransactions = this.transactionRepository.findAll(pageInfo);
				//op = "all";
			}
			else {
				pagedTransactions = this.transactionRepository.findByTimestamp(startTime, endTime, pageInfo);
				//op = "ts";
			}
		}
		else {
			if(startTime!=null || endTime!=null){
				pagedTransactions = this.transactionRepository.findByTimestampandMigrationId(startTime, endTime, migrationId, pageInfo);
				//op = "tsm";
			}
			else {
				pagedTransactions = this.transactionRepository.findByMigrationId(migrationId, pageInfo);
				//op = "m";
			}
		}
		
		List<Transaction> pagedUsers = pagedTransactions.getContent();
		PagedTransactionResponse pagedTransactionResponse = new PagedTransactionResponse();
		pagedTransactionResponse.setContent(pagedUsers);
		pagedTransactionResponse.setPageNumber(pagedTransactions.getNumber());
		pagedTransactionResponse.setPageSize(pagedTransactions.getSize());
		pagedTransactionResponse.setTotalElements(pagedTransactions.getTotalElements());
		pagedTransactionResponse.setTotalPages(pagedTransactions.getTotalPages());
		pagedTransactionResponse.setLastPage(pagedTransactions.isLast());
		//pagedTransactionResponse.setInfo(new String(startTime+" "+endTime+" "+migrationId+" ")+op);
		
		
		return pagedTransactionResponse;
		
	}

}