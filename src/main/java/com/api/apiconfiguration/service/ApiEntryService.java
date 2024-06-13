package com.api.apiconfiguration.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.apiconfiguration.entity.ApiEntry;
import com.api.apiconfiguration.repository.ApiEntryRepository;
import com.fasterxml.jackson.databind.JsonNode;

@Service
public class ApiEntryService {

	@Autowired
	private ApiEntryRepository apiEntryRepository;
	
//	@Autowired
//	private RestTemplate restTemplate;
	private RestTemplate restTemplate =new RestTemplate();
	public String insertApiValue(final int page){
		//RestTemplate restTemplate =new RestTemplate();
		String url="https://reqres.in/api/users?page="+page;
		String response;
		final JsonNode jsonNode=restTemplate.getForObject(url, JsonNode.class).get("data");
		final List<ApiEntry> apiData=new LinkedList<>();
		if(!jsonNode.isEmpty()) {
			for(final JsonNode jsonData:jsonNode) {
				apiData.add(setValue(jsonData));
			}
			this.apiEntryRepository.saveAll(apiData);
			response="successfull insert the data";
		}
		else {
			response="not data found in api";
		}
		return response;
	}

	public String updateValues() {
		String url="https://reqres.in/api/users/2";
		String response;
		JsonNode jsonNode=restTemplate.getForObject(url,JsonNode.class).get("data");
		if(!jsonNode.isEmpty()) {
			this.apiEntryRepository.save(setValue(jsonNode));
			response="update success";
		}
		else {
			response="no data found";
		}
		return response;
	}
	public ApiEntry setValue(JsonNode jsonNode) {
		ApiEntry api=new ApiEntry();
		api.setId(jsonNode.findValue("id").asLong());
		api.setFirstName(jsonNode.findValue("first_name").asText());
		api.setLastName(jsonNode.findValue("last_name").asText());
		api.setEmail(jsonNode.findValue("email").asText());
		api.setAvatar(jsonNode.findValue("avatar").asText());
		return api;
	}
}
