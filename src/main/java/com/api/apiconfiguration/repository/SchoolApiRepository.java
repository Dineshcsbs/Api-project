package com.api.apiconfiguration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.apiconfiguration.entity.SchoolApi;

@Repository
public interface SchoolApiRepository extends JpaRepository<SchoolApi, Long>{

}
