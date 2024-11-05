package com.jaeh.jh.controller;

import com.jaeh.jh.interceptor.LoginInfo;
import com.jaeh.jh.dto.request.UserLogin;
import com.jaeh.jh.dto.request.UserSignup;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jaeh.jh.model.user.User;
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
	public String doSignup(@Valid @ModelAttribute("user") UserSignup user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "signup"; // 유효성 검사 오류 처리
		}

		userService.signup(user);
		return "redirect:/";
	}

	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}

	@PostMapping("/login")
	public String doLogin(
			@ModelAttribute UserLogin user,
			HttpServletRequest request
	) {
		User foundUser = userService.login(user);
		if(foundUser == null) {
			return "redirect:/users/login";
		}
		HttpSession session = request.getSession();
		session.setAttribute("loginInfo", new LoginInfo(foundUser.getId(), foundUser.getNickname()));
		return "redirect:/";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
