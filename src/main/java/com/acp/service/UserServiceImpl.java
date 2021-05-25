package com.acp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acp.entity.User;
import com.acp.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userrepository;
	
	public List<User> getUser() {
		return userrepository.findAll();
	}
	
	public User validate(String username,String password){
		User user = userrepository.findByUsername(username).get(0);
		if(user.getPassword().equals(password)) {
			user.setPassword(null);
			return user;
		}
		return null;
	}

}
