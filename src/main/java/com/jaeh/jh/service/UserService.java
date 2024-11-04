package com.jaeh.jh.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Optional;

import com.jaeh.jh.dto.request.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaeh.jh.model.User;
import com.jaeh.jh.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository){
		this.userRepository = userRepository;
	}

	public void signup(User user){
		User newUser = new User();
		newUser.setNickname(user.getNickname());
		newUser.setEmail(user.getEmail());
		newUser.setPassword(user.getPassword());
		userRepository.save(newUser);
	}

	public User login(UserLogin user){
		Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());
		if (optionalUser.isEmpty()) {
			return null;
		}
		User foundUser= optionalUser.get();
		if (!foundUser.getPassword().equals(user.getPassword())) {
			return null;
		}
		return foundUser;
	}

}
