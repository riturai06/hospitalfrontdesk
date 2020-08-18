package com.example.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Patient;
@Repository
public interface PatientDetailsDao extends JpaRepository<Patient, Integer>{
	 
	@Modifying(clearAutomatically = true)
	    @Transactional
	    @Query(value= "UPDATE patient p, specialist s SET p.p_status = ?1 WHERE p.p_id = ?2 AND s.s_id=p.s_id", nativeQuery=true)
	    int updatePStatus(@Param("pStatus") String pStatus,@Param("pId") Integer pId);

	  
	    @Query(value= "SELECT s.name , p.patient_name  , s.type, s.available_day , s.available_time   FROM specialist s, patient p WHERE p.patient_name= :patientName AND p.s_id= s.s_id ", nativeQuery=true)
		List<Object> findByName(@Param("patientName") String patientName);

	    @Query(value= "SELECT p.p_status from patient p WHERE p.hospital_id=:hospitalId", nativeQuery=true)
        List<String> findAll(@Param("hospitalId") int hospitalId);
}
