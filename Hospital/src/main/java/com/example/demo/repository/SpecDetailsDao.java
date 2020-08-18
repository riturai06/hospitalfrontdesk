package com.example.demo.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Specialist;
@Repository
public interface SpecDetailsDao extends JpaRepository<Specialist, Integer> {
@Query(value= "SELECT * FROM specialist s,hospital h WHERE h.hospital_name =:hospitalName and s.type =:type AND h.hospital_id= s.hospital_id", nativeQuery = true)
	List<Specialist> findSpecDetails(@Param("hospitalName") String hospitalName, @Param("type") String type);

@Query(value= "SELECT * FROM specialist s WHERE s.type=:type AND s.available_time= :availableTime AND s.available_day =:availableDay ", nativeQuery = true)
List<Specialist> getDetails(@Param("type") String type,@Param("availableTime") String availableTime, @Param("availableDay") String availableDay);

}
