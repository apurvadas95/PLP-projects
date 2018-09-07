package org.spring.security.sample.model;


import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="Person")
public class Person {

	@Id
	@Column(name = "emailId")
	private String emailId;

	@Column(name="name")
	private String name;

	@Column(name = "age")
	private int age;

	@Column(name = "password")
	private String password;


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

