package com.shunya.project2021.Services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shunya.project2021.Models.User;
import com.shunya.project2021.Repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository uRepo;
	
//	public List<User> allUser(){
//		return this.uRepo.findAll();
//	}

	public User findOneUser(Long id) {
		User user = this.uRepo.findById(id).orElse(null);
		return user;
	}
	public User registerUser(User user) {
		String hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hash);
		return this.uRepo.save(user);
	}
	public boolean authenticateUser(String email, String password) {
		User user = this.uRepo.findByEmail(email);
		
		if(user==null) {
			return false;
		}
		return BCrypt.checkpw(password, user.getPassword());
	}
	public User getByEmail(String email) {
		return this.uRepo.findByEmail(email);
	}
}
