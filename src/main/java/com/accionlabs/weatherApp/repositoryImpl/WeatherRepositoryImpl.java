/*
 * Author Alok Ranjan
 */
package com.accionlabs.weatherApp.repositoryImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class WeatherRepositoryImpl  {
/*
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public Map<String, Object> saveWeatherInfo(WeatherDTO weatherDTO) {
		//entityManager.persist(weatherDTO);
		Map<String, Object> map = new HashMap<String, Object>();
		String inputId = weatherDTO.getDt();
		int weatherdt = Integer.parseInt(inputId);
		Query query = entityManager.createQuery("FROM Weather as weather where weather.dt=:dt");
		query.setParameter("dt",inputId);
		Weather result = null;
		try{
			result = (Weather) query.getSingleResult();
		}catch (NoResultException nre){
			
		}
		if(result != null) {
			int id = Integer.parseInt(result.getDt());
			if(id == weatherdt) {
				map.put("status", "you have the latest update");
			}else {
				entityManager.persist(weatherDTO);
				map.put("status", "Success");
			}
		}else {
			entityManager.persist(weatherDTO);
			map.put("status", "Success");
		}
		return map;
	}

	@Override
	public Map<String, Object> getWeatherDetails(String city) {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("City >>"+city);
		if(city != null) {
			Query query = entityManager.createQuery("FROM Weather as weather where weather.name=:city");
			query.setParameter("city",city);
			ArrayList weather = (ArrayList) query.getResultList();
			System.out.println(weather);
			if(!weather.isEmpty()) {
				map.put("status", HttpStatus.SC_OK);
				map.put("weatherinfo", weather);
			}else {
				map.put("status", HttpStatus.SC_NO_CONTENT);
				map.put("weatherinfo", "There is no data for given City");
			}
		}else{
			map.put("status", HttpStatus.SC_BAD_REQUEST);
			map.put("weatherinfo", "City should not be null");
		}
		return map;
	}
	
	@Override
	public Map<String, Object> getCities() {
		Map<String, Object> map = new HashMap<String, Object>();
		Query query = entityManager.createQuery("select distinct weather.name from Weather as weather");
		ArrayList weather = (ArrayList) query.getResultList();
			System.out.println(weather);
				map.put("status", HttpStatus.SC_OK);
				map.put("citylist", weather);
		return map;
	}
	*/
}
