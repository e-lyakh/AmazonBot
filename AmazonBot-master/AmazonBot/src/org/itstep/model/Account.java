package org.itstep.model;

/**
 * 
 * @author Evgeniy Lyakh
 *
 */
public class Account {	
	
	private String firtstName;
	private String lastName;
	private String email;
	private String password;	
	
	public String getFirtstName() {
		return firtstName;
	}
	public void setFirstName(String firtstName) {
		this.firtstName = firtstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Account() { }
	public Account(String firtstName, String lastName, String email, String password) {		
		this.firtstName = firtstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
}
