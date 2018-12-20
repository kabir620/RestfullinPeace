package com.exam.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import com.exam.model.Doctor;
import com.exam.model.JwtUser;
import com.exam.model.Patient;

@Component
public class JwtGenerator {


    public String generate(JwtUser jwtUser) {


        Claims claims = Jwts.claims()
                .setSubject(jwtUser.getUserName());
        claims.put("userId", String.valueOf(jwtUser.getId()));
        claims.put("role", jwtUser.getRole());


        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, "youtube")
                .compact();
    }
    
    
    public String generate(Patient patient) {

        Claims claims = (Claims) Jwts.claims()
                .setSubject(String.valueOf(patient.getPatientId()));
        claims.put("name", patient.getName());
        claims.put("mobile", patient.getMobile());
        claims.put("age", patient.getAge());
        claims.put("gender", patient.getGender());
        claims.put("occupation", patient.getOccupation());
        claims.put("symptomSummary", patient.getSymptomSummary());


        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, "youtube")
                .compact();
    }
    public String generate(Doctor doctor) {

        Claims claims = (Claims) Jwts.claims()
                .setSubject(String.valueOf(doctor.getDoctorId()));
        claims.put("name", doctor.getName());
        claims.put("dept", doctor.getDept());
        claims.put("joining", doctor.getJoining());
        


        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, "youtube")
                .compact();
    }
    
}
