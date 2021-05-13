package com.example.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.springboot.model.Address;
import com.example.springboot.model.User;
import com.example.springboot.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> getAllUser(String field){
		List<User> user = new ArrayList<User>();
		userRepository.findAll(Sort.by(Direction.DESC, field)).forEach(user1->user.add(user1));
		return user;
	}
	
	public List<User> getUsers(){
		List<User> u = new ArrayList<User>();
		userRepository.findAll().forEach(u1->u.add(u1));
		return u;
	}
	
	public User getUserById(Long id) {
		return userRepository.findById(id).get();
	}
	
	public User save(User u) {
		return userRepository.save(u);
		
	}
	
	public void delete(Long id) {
		userRepository.deleteById(id);
	}
	
	public void update(User user, Long id) {
		User u = userRepository.getOne(user.getId());
		u.setFirstName(u.getFirstName());
		u.setLastName(u.getLastName());
		u.setDob(u.getDob());
		u.setEmail(u.getEmail());
		u.setAddress(u.getAddress());
		userRepository.save(user);
	}

	public List<User> getUserByLastName(String lastName){
		return userRepository.getUserByLastName(lastName);
	}
	
}
