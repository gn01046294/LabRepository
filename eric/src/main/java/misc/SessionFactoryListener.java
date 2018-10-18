package misc;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import util.HibernateUtil;

@WebListener
public class SessionFactoryListener implements ServletContextListener {
	
	public void contextInitialized(ServletContextEvent sce)  { 
		HibernateUtil.getSessionFactory();
	}

	public void contextDestroyed(ServletContextEvent sce)  { 
	HibernateUtil.shutdown();	
	}

	public SessionFactoryListener() {
        
    }

	
}
