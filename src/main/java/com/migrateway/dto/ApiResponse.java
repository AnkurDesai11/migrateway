package com.migrateway.dto;

import java.util.HashMap;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
	private String message;
	private String errorElement;
	private HashMap<String, String> errors;
}
