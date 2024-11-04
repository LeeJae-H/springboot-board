package com.jaeh.jh.service;

import java.util.Optional;

import com.jaeh.jh.dto.request.UserLogin;
import com.jaeh.jh.dto.request.UserSignup;
import com.jaeh.jh.model.user.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaeh.jh.model.user.User;
import com.jaeh.jh.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository){
		this.userRepository = userRepository;
	}

	public void signup(UserSignup user){
		if (userRepository.existsByEmail(user.getEmail())) {
			throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
		}

		User newUser = User.builder()
				.email(user.getEmail())
				.password(user.getPassword())
				.nickname(user.getNickname())
				.sex(user.getSex())
				.role(UserRole.USER)
				.build();

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
