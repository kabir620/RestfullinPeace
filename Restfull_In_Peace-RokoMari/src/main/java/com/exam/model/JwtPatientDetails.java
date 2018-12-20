package com.exam.model;

import java.util.Collection;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("serial")
public class JwtPatientDetails implements UserDetails {

   private String patientId;
	
	
	private String name;
	

	private String mobile;
	

	private String age;
	
	private String gender;
	
	
	private String occupation;

	private String symptomSummary;
	
	private String token;
	
	
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	

	public JwtPatientDetails(String patientId, String name, String mobile, String age, String gender, String occupation,
			String symptomSummary, String token) {
		super();
		this.patientId = patientId;
		this.name = name;
		this.mobile = mobile;
		this.age = age;
		this.gender = gender;
		this.occupation = occupation;
		this.symptomSummary = symptomSummary;
		this.token = token;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}
