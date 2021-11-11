package com.shunya.project2021.Validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.shunya.project2021.Models.User;
import com.shunya.project2021.Repositories.UserRepository;

@Component
public class UserValidator {
	@Autowired
	private UserRepository uRepo;
	
	
	public boolean supports(User user) {
		return User.class.equals(user);
	}
	public UserRepository getuRepo() {
		return uRepo;
	}
	public void setuRepo(UserRepository uRepo) {
		this.uRepo = uRepo;
	}
	public void validate(Object target, Errors errors) {
		User user = (User)target;
		
		if(!user.getPassword().equals(user.getConfirmPassword())) {
			errors.rejectValue("password", "Match", "Password do not match");
		}
	
	if(this.uRepo.existsByEmail(user.getEmail())) {
		errors.rejectValue("email","Match", "Email already been used");
	}
	
	}
}
