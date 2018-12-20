package com.exam.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("serial")
public class JwtDoctorDetails implements UserDetails {

	private String doctorId;
    private String name;
	private String dept;
    private String joinning;
	private String token;
	
	
	
	public JwtDoctorDetails(String doctorId, String name, String dept, String joinning, String token) {
		super();
		this.doctorId = doctorId;
		this.name = name;
		this.dept = dept;
		this.joinning = joinning;
		this.token = token;
	}

	
	public String getDoctorId() {
		return doctorId;
	}


	public void setDoctorId(String doctorId) {
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


	public String getJoinning() {
		return joinning;
	}


	public void setJoinning(String joinning) {
		this.joinning = joinning;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
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
