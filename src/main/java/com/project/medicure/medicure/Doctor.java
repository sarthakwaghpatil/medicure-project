package com.project.medicure.medicure;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Doctor {
	@Id
	private int doctorRegNum;
	private String doctorName;
	private int doctorAge;
	private String doctorSpec;
	private double doctorExperience;
	private String doctorCity;
	
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Doctor(int doctorRegNum, String doctorName, int doctorAge, String doctorSpec, double doctorExperience,
			String doctorCity) {
		super();
		this.doctorRegNum = doctorRegNum;
		
		this.doctorName = doctorName;
		this.doctorAge = doctorAge;
		this.doctorSpec = doctorSpec;
		this.doctorExperience = doctorExperience;
		this.doctorCity = doctorCity;
	}
	public int getDoctorRegNum() {
		return doctorRegNum;
	}
	public void setDoctorRegNum(int doctorRegNum) {
		this.doctorRegNum = doctorRegNum;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public int getDoctorAge() {
		return doctorAge;
	}
	public void setDoctorAge(int doctorAge) {
		this.doctorAge = doctorAge;
	}
	public String getDoctorSpec() {
		return doctorSpec;
	}
	public void setDoctorSpec(String doctorSpec) {
		this.doctorSpec = doctorSpec;
	}
	public double getDoctorExperience() {
		return doctorExperience;
	}
	public void setDoctorExperience(double doctorExperience) {
		this.doctorExperience = doctorExperience;
	}
	public String getDoctorCity() {
		return doctorCity;
	}
	public void setDoctorCity(String doctorCity) {
		this.doctorCity = doctorCity;
	}

}