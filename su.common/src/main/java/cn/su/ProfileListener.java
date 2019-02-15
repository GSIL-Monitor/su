package cn.su;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 〈一句话功能简述〉;
 * 〈功能详细描述〉
 *
 * @author 18101503
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ProfileListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        String profileName = servletContext.getInitParameter("profile-name");
        System.out.println("当前profiles为："+profileName);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
