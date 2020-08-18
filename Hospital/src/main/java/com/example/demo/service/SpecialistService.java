package com.example.demo.service;
import java.util.List;

import com.example.demo.model.Specialist;

public interface SpecialistService {

	

	public List<Specialist> getSpecialistDetails(String hospitalName, String type);

	public Specialist addSpecDetails(Specialist details);

	public List<Specialist> getAll();

	public List<Specialist> IsSpecAvailable(String type, String availableTime, String availableDay);


}
