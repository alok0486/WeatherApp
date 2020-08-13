package com.accionlabs.weatherApp.exception;

public class WeatherException extends Exception{

	WeatherException(){
		super("wheather info API fails to execute due to server Error");
	}
	
}
