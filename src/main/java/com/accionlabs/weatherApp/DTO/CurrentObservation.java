package com.accionlabs.weatherApp.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrentObservation {

	@JsonProperty("wind")
	List<Wind> wind;
	@JsonProperty("atmosphere")
	List<Atmosphere> atmosphere;
	@JsonProperty("astronomy")
	List<Astronomy> astronomy;
	@JsonProperty("condition")
	List<Condition> condition;
	@JsonProperty("pubDate")
	String pubDate;
	
	public List<Wind> getWind() {
		return wind;
	}
	public void setWind(List<Wind> wind) {
		this.wind = wind;
	}
	public List<Atmosphere> getAtmosphere() {
		return atmosphere;
	}
	public void setAtmosphere(List<Atmosphere> atmosphere) {
		this.atmosphere = atmosphere;
	}
	public List<Astronomy> getAstronomy() {
		return astronomy;
	}
	public void setAstronomy(List<Astronomy> astronomy) {
		this.astronomy = astronomy;
	}
	public List<Condition> getCondition() {
		return condition;
	}
	public void setCondition(List<Condition> condition) {
		this.condition = condition;
	}
	public String getPubDate() {
		return pubDate;
	}
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	
	
}
