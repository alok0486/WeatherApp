package com.accionlabs.weatherApp.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherDTO {
	@JsonProperty("location")
	List<Location> location;
	@JsonProperty("currentObservation")
	List<CurrentObservation> currentObservation;
	@JsonProperty("forecasts")
	List<Forecasts> forecasts;
	
	public List<Location> getLocation() {
		return location;
	}
	public void setLocation(List<Location> location) {
		this.location = location;
	}
	public List<CurrentObservation> getCurrentObservation() {
		return currentObservation;
	}
	public void setCurrentObservation(List<CurrentObservation> currentObservation) {
		this.currentObservation = currentObservation;
	}
	public List<Forecasts> getForecasts() {
		return forecasts;
	}
	public void setForecasts(List<Forecasts> forecasts) {
		this.forecasts = forecasts;
	}
}
