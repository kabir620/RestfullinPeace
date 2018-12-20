package com.exam.repository;

import org.springframework.data.repository.CrudRepository;

import com.exam.model.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Integer>{

}
