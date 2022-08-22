package com.migrateway.controller;

import java.util.HashMap;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.migrateway.config.AppConstants;
import com.migrateway.dto.ApiResponse;
import com.migrateway.dto.DatabaseDto;
import com.migrateway.dto.MigrationRequestDto;
import com.migrateway.model.OperationsQueue;
import com.migrateway.service.DatabaseService;
import com.migrateway.service.QueueService;
import com.migrateway.util.ValidationException;

@RestController
@RequestMapping("/migrate")
public class MigrationController {
	
	@Autowired
	private DatabaseService databaseService;
	
	@Autowired
	private QueueService queueService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	//@MessageMapping("/new")
	//@SendTo("/ongoing")
	//public ResponseMessageDto newMigration(@RequestBody MigrationRequestDto messageDto) {
	//	
	//}
	
	//read database with name
	@GetMapping("/databases/{name}")
	public ResponseEntity<?> getUser(@PathVariable("name") String name) throws Exception {
		return new ResponseEntity<>(
			this.modelMapper.map(
				this.databaseService.getDatabase(name), DatabaseDto.class
			),
			HttpStatus.OK
		);
	}
	
	//read all databases
	@GetMapping("/databases")
	public ResponseEntity<?> getAllDatabases() throws Exception {
		return new ResponseEntity<>(
			this.databaseService.getAllDatabases().stream().map(
				database->{return this.modelMapper.map(database, DatabaseDto.class);}
			).collect(Collectors.toList()),
			HttpStatus.OK
		);
	}
	
	@PostMapping("/migration/new")
	public ResponseEntity<?> newMigration(@RequestBody MigrationRequestDto migrationRequest) throws Exception {
		OperationsQueue currentQueue = this.queueService.getQueue();
		
		HashMap<String, String> errors = new HashMap<String, String>();
		
		if(migrationRequest.getDestination().equals(migrationRequest.getSource()))
			errors.put("Same source destination", "Source "+migrationRequest.getSource()+ " and Destination "+migrationRequest.getDestination()+" cannot be the same");
		
		if(this.queueService.isQueueFull(currentQueue))
			errors.put("Concurrent Migrations", "Max concurrent migrations cannot be more than "+AppConstants.QUEUE_SIZE);
		
		if(this.queueService.isInQueue(currentQueue, AppConstants.WRITE_QUEUE, migrationRequest.getSource()))
			errors.put("Source Database", "Requested Source Database "+migrationRequest.getSource()+" is currently under write operation as it is the destination for another ongoing migration");
		
		if(this.queueService.isInQueue(currentQueue, AppConstants.WRITE_QUEUE, migrationRequest.getDestination()))
			errors.put("Destination Database", "Requested Destination Database "+migrationRequest.getDestination()+" is currently under write operation as it is the destination for another ongoing migration");
		
		if(errors.size()>=1)
			throw new ValidationException("Cannot start migration with requested parameters", "Migration request parameters", errors);
		else {
			currentQueue.setCurrentQueueSize(currentQueue.getCurrentQueueSize()+1);
			currentQueue.getReadQueue().add(migrationRequest.getSource());
			currentQueue.getWriteQueue().add(migrationRequest.getDestination());
			currentQueue = this.queueService.updateQueue(currentQueue);
			return new ResponseEntity<>(new ApiResponse("Migration request accepted", "none", null),HttpStatus.OK);
		}
		
		
	}
	
}