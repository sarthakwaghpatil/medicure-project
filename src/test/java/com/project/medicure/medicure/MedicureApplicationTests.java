package com.project.medicure.medicure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class MedicureApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	void testcreateDoctor() {
		Doctor doctor = new Doctor(001,"Sarthak",25,"heart",3.5, "A'bad");
		DoctorService dService=new DoctorService();
		assertEquals(doctor.getDoctorRegNum(),dService.createDoctor().getDoctorRegNum());
	}
	@Autowired
	DoctorRepository doctorRepository;
	
	@Test
	void testViewDoctor() {
		List<Doctor> doctor= doctorRepository.findAll();
		assertThat(doctor.size()).isEqualTo(0);
	}
	
	
}
