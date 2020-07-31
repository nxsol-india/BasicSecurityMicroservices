package com.nxpert.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nxpert.entity.User;
import com.nxpert.exception.ResourceNotFoundException;
import com.nxpert.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String usernameOrEmail)
			throws UsernameNotFoundException {
		User user = userRepository.findByUserNameOrEmail(usernameOrEmail, usernameOrEmail)
				.orElseThrow(() ->
				new UsernameNotFoundException("User not found with username or email : " + usernameOrEmail)
						);
		return UserPrincipal.create(user);
	}

	@Transactional
	public UserDetails loadUserById(Long id) {
		User user = userRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("User", "id", id)
				);
//		Optional<User> user = userRepository.findById(id);

		return UserPrincipal.create(user);
	}

}
