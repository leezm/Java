package wang.com.model;

public class User {
	private String user_name;
	private String user_password;
	private byte user_role;
	private byte oper_code;
	
	public User(String userName, String userPassword, byte userRole) {
		super();
		user_name = userName;
		user_password = userPassword;
		user_role = userRole;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public byte getOper_code() {
		return oper_code;
	}
	public void setOper_code(byte operCode) {
		oper_code = operCode;
	}
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
