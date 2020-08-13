package com.accionlabs.weatherApp.repository;

import java.util.Map;

import com.accionlabs.weatherApp.Entity.Weather;

public interface WeatherRepository {
	public Map<String, Object> saveWeatherInfo(Weather weatherDTO);

	public Map<String, Object> getWeatherDetails(String city);

	public Map<String, Object> getCities();
}
