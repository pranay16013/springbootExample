package com.example.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "address_line_1",nullable = false)
	private String addressLine1;
	
	@Column(name = "address_line_2",nullable = false)
	private String addressLine2;
	
	@Column(name = "city",nullable = false)
	private String city;
	
	@Column(name = "state",nullable = false)
	private String State;
	
	@Column(name = "pincode",nullable = false)
	private String pincode;
}
