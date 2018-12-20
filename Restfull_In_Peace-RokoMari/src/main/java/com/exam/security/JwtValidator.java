package com.exam.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import com.exam.model.Doctor;
import com.exam.model.JwtUser;
import com.exam.model.Patient;

@Component
public class JwtValidator {


    private String secret = "youtube";

    public JwtUser validateUser(String token) {

        JwtUser jwtUser = null;
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            jwtUser = new JwtUser();

            jwtUser.setUserName(body.getSubject());
            jwtUser.setId(Long.parseLong((String) body.get("userId")));
            jwtUser.setRole((String) body.get("role"));
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return jwtUser;
    }
    
    
    
    
    public Patient validatePatient(String token) {

    	Patient patient = null;
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            patient = new Patient();

            patient.setPatientId((int) body.get("patientId"));
            patient.setName((String)body.get("name"));
            patient.setMobile((String)body.get("mobile"));
            patient.setAge((String)body.get("age"));
            patient.setOccupation((String)body.get("occupation"));
            patient.setSymptomSummary((String)body.get("symptomSummary"));
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return patient;
    }
    public Doctor validateDoctor(String token) {

    	Doctor doctor = null;
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            doctor = new Doctor();

            doctor.setDoctorId((int) body.get("doctorId"));
            doctor.setName((String)body.get("name"));
            doctor.setDept((String)body.get("dept"));
            doctor.setJoining((String)body.get("joining"));
         
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return doctor;
    }
    
    
}
