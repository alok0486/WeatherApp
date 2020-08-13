package com.accionlabs.weatherApp.service;

import java.util.Map;

import com.accionlabs.weatherApp.exception.WeatherException;


public interface WeatherService {
	public Map<String, Object> fetchWeatherInfo(String city, String country) throws WeatherException;
	
}
