package com.exam.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.Patient;
import com.exam.repository.PatientRepository;

@Service
public class PatientServiceImplement implements PatiendService{
	
	@Autowired
	PatientRepository patientRepo;

	@Override
	public void insertPatient(Patient patient) {
		patientRepo.save(patient);
		
	}

	@Override
	public void updatePatient(Patient patient) {
		patientRepo.save(patient);
		
	}

	@Override
	public Patient getPatient(int id) {
		return patientRepo.findById(id).get();
	}

	@Override
	public List<Patient> getAllPatient() {
		List<Patient> patients=new ArrayList<>();
		patientRepo.findAll().forEach(patients::add);
		return patients;
	}

	@Override
	public void deletePatient(int id) {
		patientRepo.deleteById(id);
		
	}

}
