package com.exam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.Doctor;
import com.exam.model.Patient;
import com.exam.security.JwtGenerator;

@RestController
public class TokenController {


    private JwtGenerator jwtGenerator;

    public TokenController(JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }

   
    
    @GetMapping("/api/insert/patient/new")
    public String generatePatient(@RequestBody final Patient patient) {

        return jwtGenerator.generate(patient);

    }
    @PostMapping(" /api/insert/doctor/new")
    public String generateDoctor(@RequestBody final Doctor doctor) {

        return jwtGenerator.generate(doctor);

    }
   
    
}
