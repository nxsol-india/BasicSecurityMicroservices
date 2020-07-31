package com.nxpert.service;

import javax.validation.Valid;

import com.nxpert.entity.User;
import com.nxpert.payload.SignupRequest;

public interface UserService extends IFinder<User> , IService<User>{

	void registerUser(@Valid SignupRequest signUpRequest);

	
}