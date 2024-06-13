package com.api.apiconfiguration.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.apiconfiguration.entity.SchoolApi;
import com.api.apiconfiguration.repository.SchoolApiRepository;

@Service
public class SchoolApiService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private SchoolApiRepository schoolApiRepository;
	
	private final String url="http://localhost:8080/api/school/";
	
	public List<SchoolApi> getData(){
		ResponseEntity<SchoolApi[]>responseEntity=restTemplate.getForEntity(url, SchoolApi[].class);
		return Arrays.asList(responseEntity.getBody());
	}
	public void postData() {
		this.schoolApiRepository.saveAll(getData());
	}
	public SchoolApi creatRecord(SchoolApi schoolApi) {
		ResponseEntity<SchoolApi[]>responseEntity=restTemplate.postForEntity(url,schoolApi, SchoolApi[].class);
		if(responseEntity.getStatusCode()==HttpStatus.OK) {
			this.schoolApiRepository.save(schoolApi);
		}
		 return schoolApi;
	}

	public void updateData(Long id, SchoolApi school) {
		String url1=url+id;
		ResponseEntity<SchoolApi>responseEntity=restTemplate.exchange(url1, HttpMethod.PUT,new HttpEntity<>(school),SchoolApi.class);
//		ResponseEntity<SchoolApi> re=restTemplate.exchange(url1, HttpMethod.PUT, responseEntity, SchoolApi.class);
		if(responseEntity.getStatusCode()==HttpStatus.OK) {
			Optional<SchoolApi> schoolApi=schoolApiRepository.findById(id);
			if(!schoolApi.isEmpty()) {
				SchoolApi schoolData=schoolApi.get();
				if(school.getAddress()!=null) {
					schoolData.setAddress(school.getAddress());
				}
				if(school.getName()!=null) {
					schoolData.setName(school.getName());
				}
				schoolApiRepository.save(schoolData);
			}
		}
	}
	public void deleteData(Long id) {
		String url1=url+id;
		ResponseEntity<Void> responseEntity=restTemplate.exchange(url1, HttpMethod.DELETE,HttpEntity.EMPTY,Void.class);
		if(responseEntity.getStatusCode()==HttpStatus.OK) {
			this.schoolApiRepository.deleteById(id);
		}	
	}
}

	/*
	public void createrecord() {
		
		ResponseEntity<SchoolApi[]>responseEntity=restTemplate.getForEntity(url, SchoolApi[].class);
		List<SchoolApi> student=Arrays.asList(responseEntity.getBody());
		
//		System.out.print(student.get(0).getSchoolId());
//		JsonNode jsonNode=restTemplate.getForObject(url,JsonNode.class);
//		List<SchoolApi> studentDetails=new LinkedList<>();
//		if(!jsonNode.isEmpty()) {
//			for(JsonNode json:jsonNode) {
//				SchoolApi student=new SchoolApi();
//				student.setStudentId(json.findValue("id").asLong());
//				student.setName(json.findValue("name").asText());
//				student.setSchoolId(json.get("school").findValue("id").asLong());
//				student.setAddress(json.findValue("address").asText());
//				studentDetails.add(student);
//				System.out.println(student.getId());
//			}
//		}
//		schoolStudentApiRepository.saveAll(studentDetails);
		
	}
	public void update() {
		
		
	}

}
*/