package com.exam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "doctor", schema = "rokomaridb")
public class Doctor {

	@Id
	@Column(name="doctor_id")
	private int doctorId;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="dept", nullable=false)
	private String dept;
	
	@Column(name="joining", nullable=false)
	private String joining;

	public Doctor() {
		super();
	}

	public Doctor(int doctorId, String name, String dept, String joining) {
		super();
		this.doctorId = doctorId;
		this.name = name;
		this.dept = dept;
		this.joining = joining;
	}

	public Doctor(String name, String dept, String joining) {
		super();
		this.name = name;
		this.dept = dept;
		this.joining = joining;
	}
	
	

	@Override
	public String toString() {
		return "Doctor [name=" + name + ", dept=" + dept + ", joining=" + joining + "]";
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getJoining() {
		return joining;
	}

	public void setJoining(String joining) {
		this.joining = joining;
	}
	
	
}
