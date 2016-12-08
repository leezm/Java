package wang.com.config;

import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

public class DataSourceListener implements ServletContextListener {

	public static final String DATASOURCENAME = "datasourceName";
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		ServletContext sctx = arg0.getServletContext();
		
		String filename = sctx.getInitParameter("xmlconfig");
		String classname = sctx.getInitParameter("configname");
		try{
			InitialContext icxt = new InitialContext();
			DataSourceConfig config = (DataSourceConfig)Class.forName(classname).newInstance();
			config.init(filename);
			config.cleanup();
			
			DataSource ds = config.getDataSource();
			icxt.bind(DataSourceListener.DATASOURCENAME, ds);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
