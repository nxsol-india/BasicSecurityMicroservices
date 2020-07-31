package com.nxpert.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nxpert.exception.AppException;
import com.nxpert.payload.JwtAuthenticationResponse;
import com.nxpert.payload.LoginRequest;
import com.nxpert.payload.SignupRequest;
import com.nxpert.security.JwtTokenProvider;
import com.nxpert.service.UserService;

@RestController
public class AuthenticationController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtTokenProvider tokenProvider;

	@Autowired
	UserService userService;


	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		try {
			Authentication authentication = authenticationManager.
					authenticate(new UsernamePasswordAuthenticationToken
							(loginRequest.getUsernameOrEmail(),loginRequest.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			return ResponseEntity.ok(new JwtAuthenticationResponse(tokenProvider.generateToken(authentication)));
		}catch (Exception e) {
			return new ResponseEntity<AppException>(new AppException(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		try {
			userService.registerUser(signUpRequest);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<AppException>(new AppException(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
        return new ResponseEntity<String>("User registered successfully", HttpStatus.OK);
    }

}
