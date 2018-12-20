package com.exam.service;

import com.exam.model.User;

public interface UserService {
	void userRegistration(User user);
	User userLogIn(String email);
	boolean emailExist(String email);
}
