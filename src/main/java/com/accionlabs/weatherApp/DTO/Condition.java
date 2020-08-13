package com.accionlabs.weatherApp.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Condition {
	@JsonProperty("text")
	String text;
	@JsonProperty("code")
	String code;
	@JsonProperty("temperature")
	String temperature;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	
	
}
