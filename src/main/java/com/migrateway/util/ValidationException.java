package com.migrateway.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidationException extends Exception{
	
	private String message;
	private String element;
	
	
}
