package com.example.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.dto.ApiResponse;

@Service
public class SunriseService {
	
	private final String URL = "https://sun.p.rapidapi.com/api/sun/?city={cityName}";
	private RestTemplate restTemplate;
	
	public SunriseService(RestTemplateBuilder restTemplateBuilder, ClientHttpRequestInterceptor interceptor) {
		restTemplate = restTemplateBuilder.additionalInterceptors(interceptor).build();
	}
	
	// APIリクエスト
	public ApiResponse getApiResponse(String cityName) {
		ApiResponse[] apiResponses = restTemplate.getForObject(URL, ApiResponse[].class, cityName);
		ApiResponse apiResponse = new ApiResponse();
		for(ApiResponse ar : apiResponses) {
			if (ar.getDawn() != null) apiResponse.setDawn(ar.getDawn());
			if (ar.getSunrise() != null) apiResponse.setSunrise(ar.getSunrise());
			if (ar.getNoon() != null) apiResponse.setNoon(ar.getNoon());
			if (ar.getSunset() != null) apiResponse.setSunset(ar.getSunset());
			if (ar.getDusk() != null) apiResponse.setDusk(ar.getDusk());
		}
		return apiResponse;
	}
}
