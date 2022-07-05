package com.migrateway.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

	@GetMapping("/userservicefallback")
	public ResponseEntity<String> userServiceFallback(){
		
		return ResponseEntity.ok("User Source 1  down");		
	}

}
