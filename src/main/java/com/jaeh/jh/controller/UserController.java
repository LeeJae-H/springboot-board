package com.jaeh.jh.controller;

import com.jaeh.jh.dto.request.UserLogin;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jaeh.jh.model.User;
import com.jaeh.jh.service.UserService;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@GetMapping("/signup")
	public String getSignup(){
		return "signup";
	}

	@PostMapping("/signup")
	public String doSignup(@ModelAttribute("user") User user){
		userService.signup(user);
		return "home";
	}

	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}

	@PostMapping("/login")
	public String doLogin(@ModelAttribute UserLogin user,
						  HttpServletRequest request){
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		User foundUser = userService.login(user);
		if(foundUser == null) {
			return "login";
		}
		HttpSession session = request.getSession();
		session.setAttribute("loginResult", foundUser);
		return "home";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
