package com.migrateway.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.migrateway.dto.ApiResponse;


@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(RuntimeException ex){
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, "server", null);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<ApiResponse> validationExceptionHandler(ValidationException ex){
		return new ResponseEntity<ApiResponse>(new ApiResponse(ex.getMessage(), ex.getElement(), ex.getErrors()), HttpStatus.BAD_REQUEST);
	}
	
	//@ExceptionHandler(DatabaseNotFoundException.class)
	//public String databaseNotFoundExceptionHandler(DatabaseNotFoundException ex){
	//	  return "Database Not Found";
	//}
	
}
