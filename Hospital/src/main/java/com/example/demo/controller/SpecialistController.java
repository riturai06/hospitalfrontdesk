package com.example.demo.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Specialist;
import com.example.demo.service.HospitalService;
import com.example.demo.service.SpecialistService;

@RestController
public class SpecialistController {
	@Autowired 
	SpecialistService specservice;
	@Autowired 
	HospitalService hospitalservice;
	
	Logger logger = LoggerFactory.getLogger(HospitalController.class);
	
	//1. Add specialist details

		@PostMapping("/add")
		public ResponseEntity<Specialist> addSpecDetail(@RequestBody Specialist details){
			Specialist addDetails= specservice.addSpecDetails(details);
		    return new ResponseEntity<Specialist>(addDetails, HttpStatus.OK);
		}


    //2. Get All specialist details
		
	@GetMapping("/specialist")
	public ResponseEntity<List<Specialist>> getspecialist(){
		List<Specialist> getAllSpec =  specservice.getAll();
		return new ResponseEntity<List<Specialist>>(getAllSpec, HttpStatus.OK);
	}
	
	

	//3. Getting specialist details by hospital name and specialist type
	
	@GetMapping("/specialistDetails/{hospitalName}/{type}")
	public ResponseEntity<List<Specialist>> getDetails(@PathVariable String hospitalName, @PathVariable String type){
		List<Specialist> getSpecDetails= specservice.getSpecialistDetails(hospitalName, type);
		if (getSpecDetails.isEmpty()) {
	        throw new RuntimeException( type + " specialist not available in " + hospitalName);
	    } else {
	        logger.info("Response: Successfully Executed!");
	    }

	    return new ResponseEntity<List<Specialist>>(getSpecDetails, HttpStatus.OK);
	}
	
	
	
	//4. CheckAvailability
	
	@Cacheable(value = "specialist", key="{#type, #availableTime, #availableDay}")

	@GetMapping("/CheckAvailablility/{type}/{availableTime}/{availableDay}")

	public ResponseEntity<List<Specialist>> checkSpecAvailablilty(@PathVariable String type,@PathVariable String availableTime, @PathVariable String availableDay){
		List<Specialist> CheckAvailability= specservice.IsSpecAvailable(type,availableTime,availableDay);
		if (CheckAvailability.isEmpty()) {
	        throw new RuntimeException("Specialist Not Available ");
	    } else {
	        logger.info("Response: Successfully Executed!");
	    }

		return new ResponseEntity<List<Specialist>>(CheckAvailability, HttpStatus.OK);
	    	
	}


}
