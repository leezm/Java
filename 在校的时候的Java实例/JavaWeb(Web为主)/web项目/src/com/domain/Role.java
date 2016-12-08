package com.domain;

public class Role extends AbstractData {
	private byte user_role;
	private String role_name;
	public byte getUser_role() {
		return user_role;
	}
	public void setUser_role(byte user_role) {
		this.user_role = user_role;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	
}
