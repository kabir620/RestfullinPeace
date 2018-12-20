package com.exam.service;

import java.util.List;

import com.exam.model.Patient;


public interface PatiendService {

	void insertPatient(Patient patient);
	void updatePatient(Patient patient);
	Patient getPatient(int id);
	List<Patient> getAllPatient();
	void deletePatient(int id);
}
