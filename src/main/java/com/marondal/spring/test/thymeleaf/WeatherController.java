package com.marondal.spring.test.thymeleaf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marondal.spring.test.thymeleaf.domain.Weather;
import com.marondal.spring.test.thymeleaf.service.WeatherService;

@RequestMapping("/thymeleaf/weather")
@Controller
public class WeatherController {
	
	@Autowired
	private WeatherService weatherService;
	
	@ResponseBody
	@GetMapping("/create")
	public String createWeather(
//			@DateTimeFormat(pattern="yyyy년 M월 d일") @RequestParam("date") LocalDate date  // 2025년 2월 24일
//			, @RequestParam("weather") String weather
//			, @RequestParam("temperatures") double temperatures
//			, @RequestParam("precipitation") double precipitation
//			, @RequestParam("microDust") String microDust
//			, @RequestParam("windSpeed") double windSpeed
			@ModelAttribute Weather weather) {
		
//		int count = weatherService.addWeather(date, weather, temperatures, precipitation, microDust, windSpeed);
		int count = weatherService.addWeatherByObject(weather);
		
		return "삽입 결과 : " + count;
		
	}
	
	
	@GetMapping("/input")
	public String inputWeather() {
		return "thymeleaf/weather/input";	
	}
	
	@GetMapping("/list")
	public String weatherHistory(Model model) {
		List<Weather> weatherHistory = weatherService.getWeatherHistory();
		
		model.addAttribute("weatherHistory", weatherHistory);
		return "thymeleaf/weather/list";	
	}
}
