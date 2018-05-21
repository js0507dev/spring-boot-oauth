package com.jeongseop.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ExceptionHandlingController {
	@ResponseStatus(value=HttpStatus.CONFLICT, reason="Data integrity violation")
	@ExceptionHandler(DataIntegrityViolationException.class)
	public void conflict() {}
	
	@ExceptionHandler({SQLException.class, DataAccessException.class})
	public String databaseError() {
		return "databaseError";
	}
	
	@ExceptionHandler(Exception.class)
	public String handleError(HttpServletRequest req, Exception ex) {
		log.error("Request : " + req.getRequestURL() + " raised "+ex);
		
		return getErrorString(ex, req.getRequestURL().toString());
	}
	
	private String getErrorString(Exception ex, String reqURL) {
		JSONObject json = new JSONObject();
		json.put("exception", ex);
		json.put("url", reqURL);
		return json.toString();
	}
}
