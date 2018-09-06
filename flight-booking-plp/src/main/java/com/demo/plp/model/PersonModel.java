package com.demo.plp.model;


import com.demo.plp.entity.Person;

public class PersonModel {

	private String emailId;
	private String name;
	private int age;
	private String password;
	private PersonDetailsModel personDetailsModel;

	public PersonModel () {

	}

	public PersonModel (Person person) {
		this.emailId = person.getEmailId();
		this.name = person.getName();
		this.age = person.getAge();
		this.password = person.getPassword();
		this.personDetailsModel = new PersonDetailsModel(person.getPersonDetails());
	}

	public PersonDetailsModel getPersonDetailsModel() {
		return personDetailsModel;
	}

	public void setPersonDetailsModel(PersonDetailsModel personDetailsModel) {
		this.personDetailsModel = personDetailsModel;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
