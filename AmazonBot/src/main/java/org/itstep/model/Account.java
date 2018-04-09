package org.itstep.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table (name = "accounts")
public class Account {	
	
	@Id
	@Column (name = "email", length = 100)
	private String email;
	
	@Column (name = "password", length = 50, nullable = false)
	private String password;
	
	@Column (name = "first_name", length = 100, nullable = false)
	private String firstName;
	
	@Column (name = "last_name", length = 100, nullable = false)
	private String lastName;
	
	public Account() {
		this.email = "init_email";
		this.password = "init_password";
		this.firstName = "init_first_name";
		this.lastName = "init_last_name";
	}
	public Account(String email, String password, String firstName, String lastName) {		
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
}