/*
 * Author Alok Ranjan
 */

package com.accionlabs.weatherApp.serviceImpl;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.accionlabs.weatherApp.helper.WeatherInfoHelper;
import com.accionlabs.weatherApp.service.WeatherService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


@Component
public class WeatherServiceImpl implements WeatherService{

	private static final Logger logger = LoggerFactory.getLogger(WeatherServiceImpl.class);
	
	public Map<String, Object> fetchWeatherInfo(String city, String country){
		logger.info("WeatherServiceImpl() >> "+city);
		Map<String, Object> responseMap = new HashMap<String, Object>();
		try {
			String content = WeatherInfoHelper.fetchWeatherInfo(city, country);	 	
			JsonObject jObj = (new JsonParser()).parse(content).getAsJsonObject();
			ObjectMapper mapper = new ObjectMapper();
			JsonNode rootNode = mapper.readTree(content);
			JsonNode location = rootNode.path("location");
			JsonNode currentObservation = rootNode.path("current_observation");
			JsonNode forecasts = rootNode.path("forecasts");

			responseMap.put("location", location);
			responseMap.put("currentObservation", currentObservation);
			responseMap.put("forecasts", forecasts);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return responseMap;
	}

}
