package com.example.springboot.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.UserDao;
import com.example.springboot.model.User;

@Service("userService")
public class UserService {

	@Autowired
	UserDao userDao;
	
	@Transactional
	public List<User> getAllUsers(){
		return userDao.getAllUsers();
	}
	
	@Transactional
	public User getUser(int id) {
		return userDao.getUser(id);
	}
	
	@Transactional
	public void addUser(User user) {
		userDao.addUser(user);
	}
	
	@Transactional
	public void upateUser(User user) {
		userDao.updateUser(user);
	}
	
	@Transactional
	public void deleteUser(int id) {
		userDao.deleteUser(id);
	}
}
