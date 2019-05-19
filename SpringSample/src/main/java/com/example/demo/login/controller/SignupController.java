package com.example.demo.login.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.login.domain.model.SignupForm;
import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.service.UserService;

@Controller
public class SignupController {
	
	@Autowired
	private UserService userService;
	
	private Map<String, String> radioMarriage;
	
	private Map<String, String> initRadioMarriage() {
		Map<String, String> radio = new LinkedHashMap<>();
		radio.put("既婚", "true");
		radio.put("未婚", "false");
		
		return radio;
	}
	
	@GetMapping("/signup")
	public String getSignUp(
			@ModelAttribute SignupForm form,
			Model model
			) {
		radioMarriage = initRadioMarriage();
		
		model.addAttribute("radioMarriage", radioMarriage);
		
		return "login/signup";
	}
	
	@PostMapping("/signup")
	public String postSignUp(
			@ModelAttribute @Validated SignupForm form,
			BindingResult bindingResult,
			Model model
			) {
		
		if (bindingResult.hasErrors()) {
			return getSignUp(form, model);
		}
		
		System.out.println(form);
		
		User user = User.builder()
				.userId(form.getUserId())
				.password(form.getPassword())
				.userName(form.getUserName())
				.birthday(form.getBirthday())
				.age(form.getAge())
				.marriage(form.isMarriage())
				.role("ROLE_GENERAL")
				.build();
		
		boolean result = userService.insert(user);
		
		if (result) {
			System.out.println("insert 成功");
		} else {
			System.out.println("insert 失敗");
		}
		
		return "redirect:/login";
	}

}
