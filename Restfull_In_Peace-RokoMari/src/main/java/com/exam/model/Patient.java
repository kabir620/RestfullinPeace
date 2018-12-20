package com.exam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name= "patient", schema = "rokomaridb")
public class Patient {

	@Id
	@Column(name="patient_id")
	private int patientId;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="mobile", nullable=false)
	private String mobile;
	
	@Column(name="age", nullable=false)
	private String age;
	
	@Column(name="gender", nullable=false)
	private String gender;
	
	@Column(name="occupation", nullable=false)
	private String occupation;
	
	@Column(name="symptom_summary")
	private String symptomSummary;
	
	
	
	
	public Patient() {
		super();
	}




	public Patient(int patientId, String name, String mobile, String age, String gender, String occupation,
			String symptomSummary) {
		super();
		this.patientId = patientId;
		this.name = name;
		this.mobile = mobile;
		this.age = age;
		this.gender = gender;
		this.occupation = occupation;
		this.symptomSummary = symptomSummary;
	}

	



	public Patient(String name, String mobile, String age, String gender, String occupation, String symptomSummary) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.age = age;
		this.gender = gender;
		this.occupation = occupation;
		this.symptomSummary = symptomSummary;
	}




	public int getPatientId() {
		return patientId;
	}




	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getMobile() {
		return mobile;
	}




	public void setMobile(String mobile) {
		this.mobile = mobile;
	}




	public String getAge() {
		return age;
	}




	public void setAge(String age) {
		this.age = age;
	}




	public String getGender() {
		return gender;
	}




	public void setGender(String gender) {
		this.gender = gender;
	}




	public String getOccupation() {
		return occupation;
	}




	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}




	public String getSymptomSummary() {
		return symptomSummary;
	}




	public void setSymptomSummary(String symptomSummary) {
		this.symptomSummary = symptomSummary;
	}




	
	
	
}
