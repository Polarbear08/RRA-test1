package com.example.interceptor;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

@Component
public class RequestHeaderInterceptor implements ClientHttpRequestInterceptor {

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		MultiValueMap<String, String> additionalHeaders = new HttpHeaders();
		additionalHeaders.add("x-rapidapi-host", "sun.p.rapidapi.com");
		additionalHeaders.add("x-rapidapi-key", "71c324171amshe8375ce4a75f6a9p16d304jsn32be793e777f");	
		request.getHeaders().addAll(additionalHeaders);
		ClientHttpResponse response = execution.execute(request, body);
		response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
		return response;
	}

}
