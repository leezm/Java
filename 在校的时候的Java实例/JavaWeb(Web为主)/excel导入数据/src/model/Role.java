package model;

public class Role extends AbstractData {
	private byte role_id; //½ÇÉ«±àºÅ
	private String role_name; //½ÇÉ«Ãû³Æ
	public byte getRole_id() {
		return role_id;
	}
	public void setRole_id(byte role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.role_name;
	}
	
	
}
