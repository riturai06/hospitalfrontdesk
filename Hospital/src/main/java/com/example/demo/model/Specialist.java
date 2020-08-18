package com.example.demo.model;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.cache.annotation.CacheConfig;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@Entity
@CacheConfig(cacheNames={"specialist"})
public class Specialist implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer sId;
	private String type;
	private String name;
	private String availableDay;
	private String availableTime;
	
	
	@ManyToOne
	@JoinColumn(name= "hospital_id")
	private Hospital hospitaldetails;

	@OneToMany
	private List<Patient> patient;
	
	public Integer getsId() {
		return sId;
	}
	public void setsId(Integer sId) {
		this.sId = sId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAvailableDay() {
		return availableDay;
	}
	public void setAvailableDay(String availableDay) {
		this.availableDay = availableDay;
	}
	
	public String getAvailableTime() {
		return availableTime;
	}
	public void setAvailableTime(String availableTime) {
		this.availableTime = availableTime;
	}
	
		
	@Override
	public String toString() {
		return "SpecDetails [sId=" + sId + ", type=" + type + ", name=" + name + ", availableDay=" + availableDay
				+ ", availableTime=" + availableTime + "]";
	}
	public Specialist(Integer sId, String type, String name, String availableDay,String availableTime) {
		super();
		this.sId = sId;
		this.type = type;
		this.name = name;
		this.availableDay = availableDay;
		this.availableTime = availableTime;
		
	}
	public Specialist() {
	}
	
	
	

}
