package cn.su.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		String contextPath = event.getServletContext().getContextPath();
		event.getServletContext().setAttribute("base", contextPath);
	}

}
