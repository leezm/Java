package model;

public class User extends AbstractData{
	private String user_name; //用户名
	private String user_passwd;//密码
	private byte user_role; //角色
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String user_name, String user_passwd, byte user_role) {
		super();
		this.user_name = user_name;
		this.user_passwd = user_passwd;
		this.user_role = user_role;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_passwd() {
		return user_passwd;
	}
	public void setUser_passwd(String user_passwd) {
		this.user_passwd = user_passwd;
	}
	public byte getUser_role() {
		return user_role;
	}
	public void setUser_role(byte user_role) {
		this.user_role = user_role;
	}
	
}
