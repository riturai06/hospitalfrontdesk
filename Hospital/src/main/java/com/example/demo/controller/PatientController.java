package com.example.demo.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Patient;
import com.example.demo.service.HospitalService;

@RestController
public class PatientController {
	
    @Autowired
    HospitalService hospitalservice;
    
    
	
  //Patient

  //Add, update, get patients details

  //1. Add patient details

  @PostMapping("/addpatient")
  public ResponseEntity<Patient> getPatientDetail(@RequestBody Patient detail){
  	Patient addDetails= hospitalservice.addPatientDetails(detail);
      return new ResponseEntity<Patient>(addDetails, HttpStatus.OK);
  }

  //2. Get All patients details

  @Cacheable(value = "patient") //, key="{#root.methodName}"

  @GetMapping("/patients")
  public ResponseEntity<List<Patient>> getpatient(){
  	List<Patient> getAllPatient =  hospitalservice.getAll();
  	return new ResponseEntity<List<Patient>>(getAllPatient, HttpStatus.OK);
  }

//3. updating patient details

  @PutMapping("/updatepatient")
  public ResponseEntity<Patient> updatepatient(@RequestBody Patient updatePatient){
  	Patient updatedetails =  hospitalservice.getDetails(updatePatient);
  	return new ResponseEntity<Patient>(updatedetails, HttpStatus.OK);
  }

//4. Getting appointment by patient name
  
	@Cacheable(value = "appointment", key="{#root.methodName, #patientName}")
	@GetMapping("/getappointment/{patientName}")
	public ResponseEntity<List<Object>> getappointment(@PathVariable String patientName){
		List<Object> getAllAppointment =  hospitalservice.getAppointments(patientName);
		return new ResponseEntity<List<Object>>(getAllAppointment, HttpStatus.OK);

	}

//5. For updating patient status by patient id

	@CachePut(value = "appointment", key= "{#root.methodName, #pStatus, #pId}")
	@PutMapping("/updatepatientstatus/{pStatus}/{pId}")
	public Integer updatepatient(@PathVariable String pStatus, @PathVariable Integer pId){
		System.out.println("updating patient");
		int updatedetails =  hospitalservice.updateStatus(pStatus,pId);
		return new Integer(updatedetails);
	}

}
