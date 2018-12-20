package com.exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.User;
import com.exam.repository.UserRepository;

@Service
public class UserServiceImplement implements UserService{

	@Autowired
	UserRepository userRepo;
	
	@Override
	public void userRegistration(User user) {
		userRepo.save(user);
		
	}

	@Override
	public User userLogIn(String email) {
		User user=userRepo.findById(email).get();
		return user;
	}

	@Override
	public boolean emailExist(String email) {
		
		return userRepo.existsById(email);
	}

}
