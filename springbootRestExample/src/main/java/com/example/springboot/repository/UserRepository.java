package com.example.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.model.Address;
import com.example.springboot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	public List<User> getUserByLastName(String lastName);
}
