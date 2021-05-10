package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.springboot.model.User;
import com.example.springboot.services.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET,headers = "Accept=application/json")
	public String getAllUsers(Model model) {
		List<User> listofUsers = userService.getAllUsers();
		model.addAttribute("user",new User());
		model.addAttribute(listofUsers);
		return "userDetails";
		
	}
	
	@RequestMapping(value ="/",method = RequestMethod.GET,headers = "Accept=application/json")
	public String goToHomePage() {
		return "redirect:/getAllUsers";
	}
	
	 @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	    public User getUserById(@PathVariable int id) {
	        return userService.getUser(id);
	    }
	 
	    @RequestMapping(value = "/addUser", method = RequestMethod.POST, headers = "Accept=application/json")
	    public String addUser(@ModelAttribute("user") User user) {  
	        if(user.getId()==0)
	        {
	            userService.addUser(user);
	        }
	        else
	        {   
	            userService.upateUser(user);
	        }
	 
	        return "redirect:/getAllUsers";
	    }
	 
	    @RequestMapping(value = "/updateUser/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	    public String updateUser(@PathVariable("id") int id,Model model) {
	        model.addAttribute("user", this.userService.getUser(id));
	        model.addAttribute("listofUsers", this.userService.getAllUsers());
	        return "userDetails";
	    }
	 
	    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	    public String deleteUser(@PathVariable("id") int id) {
	        userService.deleteUser(id);
	        return "redirect:/getAllUsers";
	 
	    }   
}
