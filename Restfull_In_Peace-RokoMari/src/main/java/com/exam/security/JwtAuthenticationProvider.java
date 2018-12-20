package com.exam.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.exam.model.Doctor;
import com.exam.model.JwtAuthenticationToken;
import com.exam.model.JwtDoctorDetails;
import com.exam.model.JwtPatientDetails;
import com.exam.model.JwtUser;
import com.exam.model.JwtUserDetails;
import com.exam.model.Patient;

import java.util.List;

@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private JwtValidator validator;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) usernamePasswordAuthenticationToken;
        String token = jwtAuthenticationToken.getToken();

        JwtUser jwtUser = validator.validateUser(token);
        Patient patient = validator.validatePatient(token);
        Doctor doctor = validator.validateDoctor(token);
        
        

        if (jwtUser == null && patient==null && doctor==null) {
            throw new RuntimeException("JWT Token is incorrect");
        }else if(jwtUser!= null) {
        	
        	 List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                     .commaSeparatedStringToAuthorityList(jwtUser.getRole());
             return new JwtUserDetails(jwtUser.getUserName(), jwtUser.getId(),
                     token,
                     grantedAuthorities);
        	
        }else if(patient!= null) {
        	 return new JwtPatientDetails(String.valueOf(patient.getPatientId()), patient.getName(), patient.getMobile(),
            		patient.getAge(), patient.getGender(), patient.getOccupation(), patient.getSymptomSummary(), token);
        }else {
        	return new JwtDoctorDetails(String.valueOf(doctor.getDoctorId()), doctor.getName(), doctor.getDept(),
        			doctor.getJoining(),  token);
        }

       
    }
    
   
    

    
}
