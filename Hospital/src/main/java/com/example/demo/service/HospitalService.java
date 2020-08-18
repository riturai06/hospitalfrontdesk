package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Hospital;
import com.example.demo.model.Patient;



public interface HospitalService {


	
//	public List<AppointmentDetails> getAppointment(String name, String patientName, String availableDay);

	public Patient addPatientDetails(Patient details);

	public List<Patient> getAll();

	public Patient getDetails(Patient updatedetails);

	List<Object> getAppointments(String patientName);

	int updateStatus(String pStatus, Integer pId);

	int getBedsCount(String hospitalName);

	public Hospital gethospitalDetails(Hospital hospital);

	public List<Hospital> getAllHospitalDetails(Hospital hospital);

	

	



	
	
}
