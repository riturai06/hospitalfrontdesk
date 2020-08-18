package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Hospital;

@Repository
public interface HospitalDetaisDao extends JpaRepository<Hospital, Integer>{
    
	
	@Query(value= "SELECT * FROM hospital WHERE hospital_name =:hospitalName", nativeQuery=true)
	Hospital findBedsByHospitalName(String hospitalName);

	

}
