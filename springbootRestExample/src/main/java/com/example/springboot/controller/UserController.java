package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.model.Address;
import com.example.springboot.model.User;
import com.example.springboot.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping(value = "/save")
	public User save(@RequestBody User user) {
		return userService.save(user);
		
	}
	
	@PutMapping("/update")
	private User update(@RequestBody User u, Long id) {
		userService.update(u,id);
		return u;
	}
	
	@DeleteMapping("/{id}")
	private void deleteUser(@PathVariable("id") Long  id) {
		userService.delete(id);
	}
	
	@GetMapping("/user")
	private List<User> getAllUsers(@RequestParam String field){
		return userService.getAllUser(field);
	}
	
	@GetMapping("/users")
	private List<User> getUsers(){
		return userService.getUsers();
	}
	
	@GetMapping("/{lastName}")
	private List<User> getUserByLastName(@PathVariable("lastName")String lastName){
		return userService.getUserByLastName(lastName);
		
	}
}
