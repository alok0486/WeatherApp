/*
 * Author Alok Ranjan
 */

package com.accionlabs.weatherApp.controllers;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accionlabs.weatherApp.exception.WeatherException;
import com.accionlabs.weatherApp.service.WeatherService;

@RestController
public class WeatherController {

	@Autowired
	WeatherService service;
	
	private static final Logger logger = LoggerFactory.getLogger(WeatherController.class);
	
	@CrossOrigin(origins = "http://localhost:4200")
	@ExceptionHandler(WeatherException.class) 
	@GetMapping(value = "/weatherInfo/{city}/{country}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Map<String, Object> fetchWeatherInfo(@PathVariable String city, @PathVariable String country ) throws WeatherException {
		logger.info("Inside WeatherController fetchWeatherInfo() ---"+city);
		Map<String, Object> response = null;
			response = service.fetchWeatherInfo(city,country);
		return response;
	}
}
