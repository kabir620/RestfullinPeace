package com.exam;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.Doctor;
import com.exam.model.Patient;
import com.exam.model.User;
import com.exam.service.DoctorService;
import com.exam.service.PatiendService;
import com.exam.service.UserService;

@RestController
public class HospitalController {

    @Autowired
	PatiendService patientService;
    
	@RequestMapping(value="/api/insert/patient/new", method=RequestMethod.POST)
	public ResponseEntity<?> insertPatient(@RequestBody Patient patient) {
		patientService.insertPatient(patient);
		List<String> list=new ArrayList<>();
		list.add("'Status':'success'");
		return new ResponseEntity<List<String>>(list, HttpStatus.OK);
	}
    
    
    @RequestMapping(value="/api/patients", method=RequestMethod.GET)
	public List<Patient> getAllPatient() {
		return patientService.getAllPatient();
	}
    
    
    @RequestMapping(value="/api/patients/{id}", method=RequestMethod.GET)
	public Patient getPatient(@PathVariable("id") int id) {
		return patientService.getPatient(id);
	}
	
	@RequestMapping(value="api/update/patients", method=RequestMethod.PUT)
	public ResponseEntity<?> updatePatient(@RequestBody Patient patient) {
		 patientService.updatePatient(patient);
		 List<String> list=new ArrayList<>();
			list.add("'Status':'updated'");
			return new ResponseEntity<List<String>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value="api/delete/patients/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deletePatient(@PathVariable("id") int id) {
		 patientService.deletePatient(id);
		 List<String> list=new ArrayList<>();
			list.add("'Status':'deleted'");
			return new ResponseEntity<List<String>>(list, HttpStatus.OK);
	}
	
	
	
	//For Perform basic CRUD on doctor's table
	
	@Autowired
	DoctorService doctorService;
	
	
	@RequestMapping(value="/api/insert/doctor/new", method=RequestMethod.POST)
	public ResponseEntity<?> insertDoctor(@RequestBody Doctor doctor) {
		doctorService.insertDoctor(doctor);
		List<String> list=new ArrayList<>();
		list.add("'Status':'success'");
		return new ResponseEntity<List<String>>(list, HttpStatus.OK);
	}
	@RequestMapping(value="/api/doctors", method=RequestMethod.GET)
	public List<Doctor> getAllDoctor() {
		return doctorService.getAllDoctor();
	}
	
	@RequestMapping(value="/api/doctors/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> getDoctor(@PathVariable("id") int id) {
		Doctor doctor= doctorService.getDoctor(id);
		List<String> list=new ArrayList<>();
		list.add("name: "+doctor.getName());
		list.add("dept: "+doctor.getDept());
		list.add("Joining: "+doctor.getJoining());
		return new ResponseEntity<List<String>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value="api/update/doctors", method=RequestMethod.PUT)
	public ResponseEntity<?> updateDoctor(@RequestBody Doctor doctor) {
		doctorService.updateDoctor(doctor);
		List<String> result=new ArrayList<>();
		result.add("'Status':'updated'");
		return new ResponseEntity<List<String>>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value="api/delete/doctors/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deletedoctor(@PathVariable("id") int id) {
		doctorService.deleteDoctor(id);
		List<String> result=new ArrayList<>();
		result.add("'Status':'deleted'");
		return new ResponseEntity<List<String>>(result, HttpStatus.OK);
	}
	
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ResponseEntity<?> registrationUser(@RequestBody User user) {
		userService.userRegistration(user);
		List<String> list=new ArrayList<>();
		list.add("'Status':'success'");
		return new ResponseEntity<List<String>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ResponseEntity<?> userLogin(@RequestBody User user) {
		
		List<String> list=new ArrayList<>();
		
		if(userService.emailExist(user.getEmail())) {
			
		User exist=userService.userLogIn(user.getEmail());
		if(exist.getPassword().equals(user.getPassword())) {
			list.add("'Status':'logged in'");
			list.add("first_name:"+exist.getFirstName());
			list.add("email:"+exist.getEmail());
			return new ResponseEntity<List<String>>(list, HttpStatus.OK);
		}else {
			list.add("'Status':'Log in failed'");
			return new ResponseEntity<List<String>>(list, HttpStatus.OK);
		}
		
		}else {
			list.add("'Status':'Log in failed'");
			return new ResponseEntity<List<String>>(list, HttpStatus.OK);
		}
		
	}
    
    
    
    
}
