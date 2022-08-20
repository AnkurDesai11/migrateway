package com.migrateway.controller;

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

import com.migrateway.dto.ApiResponse;
import com.migrateway.dto.DatabaseDto;
import com.migrateway.dto.MigrationRequestDto;
import com.migrateway.model.OperationsQueue;
import com.migrateway.service.DatabaseService;
import com.migrateway.service.QueueService;

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
		currentQueue.getReadQueue().add(migrationRequest.getSource());
		currentQueue.getWriteQueue().add(migrationRequest.getDestination());
		currentQueue = this.queueService.updateQueue(currentQueue);
		return new ResponseEntity<>(new ApiResponse("Migration request accepted", "none", null),HttpStatus.OK);
	}
	
}