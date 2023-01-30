package com.project.medicure.medicure;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
	@Autowired
	DoctorRepository doctorRepository;

	public Doctor createDoctor() {
		Doctor doctor = new Doctor(001,"Sarthak",25,"heart",3.5, "A'bad");
		return doctor;
	}

	public Doctor registerDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	public Doctor updateDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return doctorRepository.save(doctor);
	}

	public Doctor searchDoctor(String doctorName) {
		// TODO Auto-generated method stub
		return doctorRepository.findByDoctorName(doctorName);
	}

	public void deleteDoctorById(int doctorRegNum) {
		// TODO Auto-generated method stub
		doctorRepository.deleteById(doctorRegNum);
	}

	public List<Doctor> getAllDoctors() {
		List<Doctor> doctors = new ArrayList<Doctor>();
	      doctorRepository.findAll().forEach(doctor -> doctors.add(doctor));
	      return doctors;
	}	
	
	

	



	

	



	
}