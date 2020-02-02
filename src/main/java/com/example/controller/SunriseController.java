package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dto.ApiResponse;
import com.example.service.SunriseService;

@Controller
public class SunriseController {
	
	private final SunriseService sunriseService;
	
	public SunriseController(SunriseService sunriseService) {
		this.sunriseService = sunriseService;
	}
	
	@GetMapping({"/", "/index"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/result")
	public String result(@RequestParam String cityName, Model model) {
		ApiResponse apiResponse = sunriseService.getApiResponse(cityName);
		model.addAttribute("cityName", cityName);
		model.addAttribute("apiResponse", apiResponse);
		return "result";
	}

}
