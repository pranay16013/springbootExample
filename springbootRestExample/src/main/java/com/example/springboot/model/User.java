package com.example.springboot.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_Name",nullable = false)
	private String firstName;
	
	@Column(name = "last_name",nullable = false)
	private String lastName;
	
	@Column(name = "dob",nullable = false)
	private Date dob;
	
	@Column(name = "joining_date",nullable = false)
	private Date joiningDate;
	
	@Column(name = "email",nullable = false)
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
	private Address address;
}
