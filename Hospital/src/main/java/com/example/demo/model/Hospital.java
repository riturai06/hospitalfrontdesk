package com.example.demo.model;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
@Entity
public class Hospital implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer hospitalId;
	private String hospitalName;
	private Integer noOfBeds;
	@OneToMany
	private List<Specialist> spec;
	
	@OneToMany
	private List<Patient> patient;
	
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public Integer getNoOfBeds() {
		return noOfBeds;
	}
	public void setNoOfBeds(Integer noOfBeds) {
		this.noOfBeds = noOfBeds;
	}
	
	@Override
	public String toString() {
		return "HospitalDetails [hospitalId=" + hospitalId + ", hospitalName=" + hospitalName + ", noOfBeds=" + noOfBeds
				+ "]";
	}
	public Hospital(Integer hospitalId, String hospitalName, Integer noOfBeds, String pStatus) {
		super();
		this.hospitalId = hospitalId;
		this.hospitalName = hospitalName;
		this.noOfBeds = noOfBeds;
		
	}
	public Hospital() {
		
	}

	
	
	
}