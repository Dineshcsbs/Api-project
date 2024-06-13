package com.api.apiconfiguration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.apiconfiguration.service.ApiEntryService;



@RestController
@RequestMapping("/api/third")
public class ApiEntryController {

	@Autowired
	ApiEntryService apiEntryService;
	
	@PostMapping("/insert-api-values")
	public String insertApiValues(@RequestParam int page){
		return apiEntryService.insertApiValue(page);
	}
	
	@PutMapping("/")
	public String updateValues() {
		return apiEntryService.updateValues();
	}
	
	
}
