package wang.com.config;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class SQLServerConfig extends DataSourceConfig {

	@Override
	public void init(String filename) {
		// TODO Auto-generated method stub
		super.init(filename);
		ds = new SQLServerDataSource();
		((SQLServerDataSource)ds).setServerName(server);
		((SQLServerDataSource)ds).setPortNumber(port);
		((SQLServerDataSource)ds).setDatabaseName(databaseName);
		((SQLServerDataSource)ds).setUser(user);
		((SQLServerDataSource)ds).setPassword(password);
	}

	
}
