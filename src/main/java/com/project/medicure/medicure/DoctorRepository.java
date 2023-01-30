package com.project.medicure.medicure;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

	Doctor findByDoctorName(String doctorName);




}
