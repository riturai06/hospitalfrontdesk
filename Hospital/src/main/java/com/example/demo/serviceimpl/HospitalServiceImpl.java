package com.example.demo.serviceimpl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.example.demo.HospitalApplication;
import com.example.demo.model.Hospital;
import com.example.demo.model.Patient;
import com.example.demo.repository.HospitalDetaisDao;
import com.example.demo.repository.PatientDetailsDao;
import com.example.demo.service.HospitalService;
@Service
public class HospitalServiceImpl implements HospitalService {
    @Autowired
   PatientDetailsDao patientdao;
    
 
    
    @Autowired
    HospitalDetaisDao hospitaldao;
    
  
    private static final Logger logger = LoggerFactory.getLogger(HospitalApplication.class);
	@Override
	public Patient addPatientDetails(Patient pDetails) {
	
		return patientdao.save(pDetails);
	}

	@Override
	public List<Patient> getAll() {
		return patientdao.findAll();
	}

	@Override
	public Patient getDetails(Patient updatedetails) {
		// TODO Auto-generated method stub
		return patientdao.save(updatedetails);
	}
	
	
	@Cacheable(cacheNames= "appointment")
	@Override
	public List<Object> getAppointments(String patientName) {
		logger.info("getting from db");
		System.out.println("fetching appointment details for " + patientName);
		return patientdao.findByName(patientName);
	}

	@Override
	@Cacheable(cacheNames= "appointment")
	public int updateStatus(String pStatus,Integer pId) {
		return patientdao.updatePStatus(pStatus,pId);
	}

	@Override
	public int getBedsCount(String hospitalName) {
		Hospital hospital = hospitaldao.findBedsByHospitalName(hospitalName);
		List<String> patient= findAllPatient(hospital.getHospitalId());
		for(String pt: patient) {
			if(pt.matches("Admit")) {
				hospital.setNoOfBeds(hospital.getNoOfBeds()-1);
			}
			else if(pt.matches("Discharge")) {
				hospital.setNoOfBeds(hospital.getNoOfBeds()+1);
			}
		
			
		}
		return hospital.getNoOfBeds();
			
		//List<Patient> patient = (List<Patient>) new Patient();
//		Integer result = hospitaldao.getNoofbeds(hospitalId);
//		Object patient = new Patient();
//		if(((Patient) patient).getpStatus()"ADMIT")
//		{ 
//			long  count = patientdao.count();
//		    result= (int) (((Hospital) patient).getNoOfBeds()+count);
//		}
//		else if(((Patient) patient).getpStatus()=="DISCHARGE") {	
//			long  count1 = patientdao.count();
//		    result= (int) (((Hospital) patient).getNoOfBeds()-count1);
//		
//		}
//		return result;
		

		}

	private List<String> findAllPatient(Integer hospitalId) {
		
		return patientdao.findAll(hospitalId);
	}

	@Override
	public Hospital gethospitalDetails(Hospital hospital) {
	
		return hospitaldao.save(hospital);
	}

	@Override
	public List<Hospital> getAllHospitalDetails(Hospital hospital) {
		
		return hospitaldao.findAll();
	}

	
		
	}

	
	
	


