package com.domain;



public class User extends AbstractData {
	private String user_name;
	private String user_password;
	private byte user_role;
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String userName) {
		user_name = userName;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String userPassword) {
		user_password = userPassword;
	}
	public byte getUser_role() {
		return user_role;
	}
	public void setUser_role(byte userRole) {
		user_role = userRole;
	}
	
	
}
