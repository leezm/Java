package wang.com.model;

public final class Role {
	private byte role_id;
	private String role_name;
	private byte operCode;
	
	public byte getOperCode() {
		return operCode;
	}
	public void setOperCode(byte operCode) {
		this.operCode = operCode;
	}
	public byte getRole_id() {
		return role_id;
	}
	public void setRole_id(byte roleId) {
		role_id = roleId;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String roleName) {
		role_name = roleName;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.role_name;
	}
	
	
}
