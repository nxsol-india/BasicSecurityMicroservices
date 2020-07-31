package com.nxpert.serviceImpl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nxpert.entity.User;
import com.nxpert.payload.SignupRequest;
import com.nxpert.repository.UserRepository;
import com.nxpert.service.BasicService;
import com.nxpert.service.UserService;

@Service
public class UserServiceImpl extends BasicService<User, UserRepository> implements UserService{

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public void registerUser(@Valid SignupRequest signUpRequest) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setEmail(signUpRequest.getEmail());
		user.setUserName(signUpRequest.getUserName());
		user.setName(signUpRequest.getName());
		user.setRole(signUpRequest.getRole());
		user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
		repository.save(user);
		
	}


	

	

}