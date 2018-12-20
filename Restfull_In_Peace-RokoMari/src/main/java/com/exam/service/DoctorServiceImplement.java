package com.exam.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.Doctor;
import com.exam.repository.DoctorRepository;


@Service
public class DoctorServiceImplement implements DoctorService{

	
	@Autowired
	DoctorRepository doctorRepo;
	
	
	@Override
	public void insertDoctor(Doctor doctor) {
		doctorRepo.save(doctor);
		
	}

	@Override
	public void updateDoctor(Doctor doctor) {
		doctorRepo.save(doctor);
		
	}

	@Override
	public Doctor getDoctor(int id) {
		return doctorRepo.findById(id).get();
	}

	@Override
	public List<Doctor> getAllDoctor() {
	    List<Doctor> doctors=new ArrayList<>();
		doctorRepo.findAll().forEach(doctors::add);
		return doctors;
	}

	@Override
	public void deleteDoctor(int id) {
		doctorRepo.deleteById(id);
		}

}
