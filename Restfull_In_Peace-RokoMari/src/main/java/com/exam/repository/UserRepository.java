package com.exam.repository;

import org.springframework.data.repository.CrudRepository;

import com.exam.model.User;

public interface UserRepository extends CrudRepository<User, String>{

}
