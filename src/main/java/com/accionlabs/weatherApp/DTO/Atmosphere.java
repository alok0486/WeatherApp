package com.accionlabs.weatherApp.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Atmosphere {
	@JsonProperty("humidity")
	String humidity;
	@JsonProperty("visibility")
	String visibility;
	@JsonProperty("pressure")
	String pressure;
	@JsonProperty("rising")
	String rising;
	
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	public String getVisibility() {
		return visibility;
	}
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	public String getPressure() {
		return pressure;
	}
	public void setPressure(String pressure) {
		this.pressure = pressure;
	}
	public String getRising() {
		return rising;
	}
	public void setRising(String rising) {
		this.rising = rising;
	}
}
