package com.tamara.tamarapaymentapi.api.control;

import com.tamara.tamarapaymentapi.api.boundry.bo.UserDTO;
import com.tamara.tamarapaymentapi.api.control.exception.ServiceError;
import com.tamara.tamarapaymentapi.api.entity.User;
import com.tamara.tamarapaymentapi.api.entity.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistrationService {

	private UserRepository userRepository;

	public RegistrationService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User registerUser(UserDTO userDTO) {
		Optional<User> optionalUser = userRepository.findByName(userDTO.getName());
		if (optionalUser.isPresent()) {
			throw ServiceError.USER_ALREADY_EXIST.buildException();
		}
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		User user = new User();
		user.setName(userDTO.getName());
		user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		user.setRoles("ROLE_ADMIN");

		return userRepository.save(user);
	}
}
