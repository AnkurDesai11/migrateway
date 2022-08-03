package com.migrateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.migrateway.dto.MigrationRequestDto;
import com.migrateway.service.DatabaseService;

@RestController
@RequestMapping("/migrate")
public class MigrationController {
	
	@Autowired
	private DatabaseService databaseService;
	
	//@MessageMapping("/new")
	//@SendTo("/ongoing")
	//public ResponseMessageDto newMigration(@RequestBody MigrationRequestDto messageDto) {
	//	
	//}
	
	//read database with name
	@GetMapping("/databases/{name}")
	public ResponseEntity<?> getUser(@PathVariable("name") String name) throws Exception {
		return new ResponseEntity<>(this.databaseService.getDatabase(name),HttpStatus.OK);
	}
	
	//read all databases
	@GetMapping("/databases")
	public ResponseEntity<?> getAllDatabases() throws Exception {
		return new ResponseEntity<>(this.databaseService.getAllDatabases(),HttpStatus.OK);
	}
	
}