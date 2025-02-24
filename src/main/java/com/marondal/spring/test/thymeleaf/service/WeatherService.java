package com.marondal.spring.test.thymeleaf.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marondal.spring.test.thymeleaf.domain.Weather;
import com.marondal.spring.test.thymeleaf.repository.WeatherRepository;

@Service
public class WeatherService {
	
	@Autowired
	private WeatherRepository weatherRepository;
	
	public int addWeather(
			LocalDate date
			, String weather
			, double temperatures
			, double precipitation
			, String microdust
			, double windSpeed) {
		
		int count = weatherRepository.insertWeather(date, weather, temperatures, precipitation, microdust, windSpeed);

		return count;
	}
	
	public int addWeatherByObject(Weather weather) {
		int count = weatherRepository.insertWeatherByObejct(weather);
		return count;
	}
	
	public List<Weather> getWeatherHistory() {
		List<Weather> weatherHistory = weatherRepository.selectWeatherHistory();
		return weatherHistory;
	}

}
