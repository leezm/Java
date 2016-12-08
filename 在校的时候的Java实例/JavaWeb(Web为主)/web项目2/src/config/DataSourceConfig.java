package wang.com.config;

import javax.sql.DataSource;



public abstract class DataSourceConfig extends Config {

	protected DataSource ds;
	
	public static final String SERVER = "Server";
	public static final String PORT = "Port";
	public static final String DATABASENAME = "DatabaseName";
	public static final String USER = "User";
	public static final String PASSWORD = "Password";
	
	protected String server;
	protected int port;
	protected String databaseName;
	protected String user;
	protected String password;
	
	@Override
	public void init(String filename) {
		// TODO Auto-generated method stub
		super.init(filename);
		server = getValue(root, SERVER);
		port = Integer.parseInt(getValue(root, PORT));
		databaseName = getValue(root, DATABASENAME);
		user = getValue(root, USER);
		password = getValue(root, PASSWORD);
	}
	
	public DataSource getDataSource(){
		return ds;
	}
}
