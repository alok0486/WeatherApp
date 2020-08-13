package com.accionlabs.weatherApp.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Wind {

	@JsonProperty("chill")
	String chill;
	@JsonProperty("direction")
	String direction;
	@JsonProperty("speed")
	String speed;
	
	public String getChill() {
		return chill;
	}
	public void setChill(String chill) {
		this.chill = chill;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getSpeed() {
		return speed;
	}
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	
	
}
