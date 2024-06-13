package com.api.apiconfiguration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.apiconfiguration.entity.SchoolApi;
import com.api.apiconfiguration.service.SchoolApiService;

@RestController
@RequestMapping("/api/third/school")
public class SchoolApicontroller {

	@Autowired
	private SchoolApiService schoolApiService;
	
	@GetMapping("/")
	public List<SchoolApi> getData(){
		return this.schoolApiService.getData();
	}
	
	@PostMapping("/update")
	public void postData() {
		this.schoolApiService.postData();
	}
	@PostMapping("/insert")
	public SchoolApi createRecord(@RequestBody SchoolApi school) {
		return this.schoolApiService.creatRecord(school);
	}
	
	@PutMapping("/{id}")
	public void updateData(@PathVariable Long id,@RequestBody SchoolApi school) {
		this.schoolApiService.updateData(id,school);
	}
	@DeleteMapping("/{id}")
	public void update(@PathVariable Long id) {
		schoolApiService.deleteData(id);
	}
}
