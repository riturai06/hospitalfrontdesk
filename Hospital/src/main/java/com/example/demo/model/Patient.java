package com.example.demo.model;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Value;

@Entity
public class Patient implements  Serializable {

	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy= GenerationType.AUTO)
private Integer pId;
private String patientName;
private Long MobileNo;
private String pStatus;
@ManyToOne
@JoinColumn(name="hospital_id")
private Hospital hospitaldetails;

@ManyToOne
@JoinColumn(name= "s_id")
private Specialist specialist;
public Integer getpId() {
	return pId;
}
public void setpId(Integer pId) {
	this.pId = pId;
}
public String getPatientName() {
	return patientName;
}
public void setPatientName(String patientName) {
	this.patientName = patientName;
}
public Long getMobileNo() {
	return MobileNo;
}
public void setMobileNo(Long mobileNo) {
	MobileNo = mobileNo;
}


public String getpStatus() {
	return pStatus;
}
public void setpStatus(String pStatus) {
	this.pStatus = pStatus;
}

@Override
public String toString() {
	return "PatientDetails [pId=" + pId + ", patientName=" + patientName + ", MobileNo=" + MobileNo + ", pStatus="
			+ pStatus + "]";
}

public Patient(Integer pId, String patientName, Long mobileNo, String pStatus) {
	super();
	this.pId = pId;
	this.patientName = patientName;
	MobileNo = mobileNo;
	this.pStatus = pStatus;
}
public Patient() {
	
}


}
