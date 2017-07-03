/**
 * 
 */
package com.rest.server;

import com.rest.common.Constants;
import com.rest.common.MySqlDBHandler;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.SQLException;

/**
 * @author wanjia
 *
 */
public class MySqlInit implements ServletContextListener {

	/**
	 * 
	 */
	public MySqlInit() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
//	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	
	//@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		try {
			MySqlDBHandler.connectDB(Constants.MYSQLURL);
		} catch (ClassNotFoundException e){// | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
