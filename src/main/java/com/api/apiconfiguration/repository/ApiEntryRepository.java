package com.api.apiconfiguration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.apiconfiguration.entity.ApiEntry;
@Repository
public interface ApiEntryRepository extends JpaRepository<ApiEntry, Long>{

	

}
