package com.exam.service;

import java.util.List;

import com.exam.model.Doctor;


public interface DoctorService {

	void insertDoctor(Doctor doctor);
	void updateDoctor(Doctor doctor);
	Doctor getDoctor(int id);
	List<Doctor> getAllDoctor();
	void deleteDoctor(int id);
}
