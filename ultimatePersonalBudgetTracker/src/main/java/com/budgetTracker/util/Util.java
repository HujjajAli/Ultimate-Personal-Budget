package com.budgetTracker.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Util {

	public static ResponseEntity<?> getCustomeResponse(HttpStatus httpStatus,String message,Object object){
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		//map.put("responseCode", map);
		map.put("message", message);
		map.put("data", object);
		
		return ResponseEntity.status(httpStatus).body(map);
		
	}
	
}
