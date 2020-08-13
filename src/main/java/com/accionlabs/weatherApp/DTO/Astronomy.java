package com.accionlabs.weatherApp.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Astronomy {
	@JsonProperty("sunrise")
	String sunrise;
	@JsonProperty("sunset")
	String sunset;
	public String getSunrise() {
		return sunrise;
	}
	public void setSunrise(String sunrise) {
		this.sunrise = sunrise;
	}
	public String getSunset() {
		return sunset;
	}
	public void setSunset(String sunset) {
		this.sunset = sunset;
	}
}
