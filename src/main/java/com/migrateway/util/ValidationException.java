package com.migrateway.util;

import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ValidationException extends Exception{
	
	private String message;
	private String element;
	private HashMap<String, String> errors;
	
}
