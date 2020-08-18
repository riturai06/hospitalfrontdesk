package com.example.demo.serviceimpl;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.HospitalApplication;
import com.example.demo.model.Specialist;
import com.example.demo.repository.SpecDetailsDao;
import com.example.demo.service.SpecialistService;


@Service
public class SpecialistServiceImpl implements SpecialistService {
@Autowired
SpecDetailsDao specDao;
private static final Logger logger = LoggerFactory.getLogger(HospitalApplication.class);
	@Override
	public Specialist addSpecDetails(Specialist details) {
		
		return specDao.save(details);
	}
	@Override
	public List<Specialist> getSpecialistDetails(String hospitalName, String type) {
		
		return specDao.findSpecDetails(hospitalName, type);
	}
	
	@Override
	public List<Specialist> getAll() {
		
		return (List<Specialist>) specDao.findAll();
	}
	
	@Override
	@Cacheable(cacheNames= "specialist")
	public List<Specialist> IsSpecAvailable(String type, String availableTime, String availableDay) {
		// TODO Auto-generated method stub
		logger.info("fetched details from db");
		return specDao.getDetails(type,availableTime,  availableDay);
	}
	
	

}
