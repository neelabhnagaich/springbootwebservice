package com.neelabh.rest.restfullwebservices.user;

import java.time.LocalDate;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;


public class User {

	private int id;
	
	@Size(min=2, message="Name shoudl have chars greater than 3")
	private String name;
	
	@Past(message="Birthdate should be in the past ")
	private LocalDate birthdate;
	
	public User(int id, String name, LocalDate birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
}
