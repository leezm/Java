package com;

public class User {

	private String username;
	private String password;
	private int role;
	private byte opercode;
	
	
	public byte getOpercode() {
		return opercode;
	}
	public void setOpercode(byte opercode) {
		this.opercode = opercode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return username + "\t" + password + "\t" + role;
	}
	
}
