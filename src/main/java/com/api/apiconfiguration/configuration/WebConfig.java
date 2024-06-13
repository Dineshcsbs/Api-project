package com.api.apiconfiguration.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WebConfig {

    @Bean
    RestTemplate restTemplate() {
		return new RestTemplate();
	}/*
    public PaginatedResponseDTO<School> searchSchools(SearchRequestDTO searchRequest) {
        Page<School> schoolPage = schoolrepository.searchSchools(
            searchRequest.getName(), 
            searchRequest.getAddress(), 
            searchRequest.getId(), 
            PageRequest.of(searchRequest.getPage(), searchRequest.getSize())
           
        );

        PaginatedResponseDTO<School> response = new PaginatedResponseDTO<>();
        response.setData(schoolPage.getContent());
        response.setPageNumber(schoolPage.getNumber());
        response.setPageSize(schoolPage.getSize());
        response.setTotalElements(schoolPage.getTotalElements());
        response.setTotalPages(schoolPage.getTotalPages());

        return response;
    }
    */
}
