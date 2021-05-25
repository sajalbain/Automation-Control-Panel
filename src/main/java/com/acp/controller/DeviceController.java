package com.acp.controller;

import java.util.Arrays;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

@RestController
@RequestMapping("/device")
public class DeviceController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping("/temperature")
	public JSONObject getTemperature() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity <String> entity = new HttpEntity<String>(headers);
		JSONParser parser = new JSONParser();  
		JSONObject json = null;
		try {
			json =  (JSONObject) parser.parse(restTemplate.exchange("http://192.168.1.253", HttpMethod.GET, entity, String.class).getBody());
		} catch (RestClientException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		return json;
	}
	
	@RequestMapping("/add")
	public String addDevice(@RequestParam(name="name") String name,@RequestParam(name="ip") String ip) {
		
		return null;
	}

}
