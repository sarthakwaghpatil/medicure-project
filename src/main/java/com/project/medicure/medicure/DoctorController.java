package com.project.medicure.medicure;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {
	
	@Autowired
	DoctorService doctorService;
	
	@GetMapping("/createDoctor")
	public Doctor createDoctor() {
		return doctorService.createDoctor();
	}
	
	@PostMapping("/registerDoctor")
	public Doctor registerDoctor(@RequestBody Doctor doctor) {
		return doctorService.registerDoctor(doctor);
	}
	
	@PutMapping("/updateDoctor/{doctorRegNum}")
	public Doctor updateDoctor(@RequestBody Doctor doctor, @PathVariable int doctorRegNum) {
		return doctorService.updateDoctor(doctor);
	}
	@GetMapping("/searchDoctor/{doctorName}")
	public Doctor searchDoctor(@PathVariable(value="doctorName")String doctorName) {
		return doctorService.searchDoctor(doctorName);
	}
	@DeleteMapping("/deleteDoctor/{doctorRegNum}")
	public void deleteDoctor(@PathVariable("doctorRegNum")int doctorRegNum) {
		doctorService.deleteDoctorById(doctorRegNum);
	}
	
	@GetMapping("/viewAll")
	public List<Doctor> getAllDoctors(){
		return doctorService.getAllDoctors();
	}

	
	
	
	
	

}