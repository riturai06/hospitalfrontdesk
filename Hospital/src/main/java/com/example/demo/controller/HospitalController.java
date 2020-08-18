package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Hospital;
import com.example.demo.service.HospitalService;
import com.example.demo.service.SpecialistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class HospitalController {

	@Autowired 
	SpecialistService specservice;
	@Autowired 
	HospitalService hospitalservice;
	
	Logger logger = LoggerFactory.getLogger(HospitalController.class);



//hospital details
	
	
//1. Add Hospital Details
	
	@PostMapping("/addHospitalDetails")
	public ResponseEntity<Hospital> addhospital(@RequestBody Hospital hospital){
	  	Hospital hospitaldetails =  hospitalservice.gethospitalDetails(hospital);
	  	return new ResponseEntity<Hospital>(hospitaldetails, HttpStatus.OK);
	  }
//2. Get Hospital Details
	
	@GetMapping("/getHospitalDetails")
	public List<Hospital> getNoOfBeds(@RequestBody Hospital hospital){
	return hospitalservice.getAllHospitalDetails(hospital);	
	}
	
//3. Get beds availability according to hospital name
	
   @GetMapping("/noOfbedAvailable/{hospitalName}")
   public int getNoOfBeds(@PathVariable String hospitalName){
   return hospitalservice.getBedsCount(hospitalName);
  

	
}




}
