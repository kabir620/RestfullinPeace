package com.exam.repository;

import org.springframework.data.repository.CrudRepository;

import com.exam.model.Patient;

public interface PatientRepository extends CrudRepository<Patient, Integer>{

}
