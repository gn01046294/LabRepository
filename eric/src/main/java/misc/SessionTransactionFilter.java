package misc;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.hibernate.HibernateException;

import util.HibernateUtil;

@WebFilter(urlPatterns= {"/*"})
public class SessionTransactionFilter implements Filter {
    public SessionTransactionFilter() {}

    public void init(FilterConfig fConfig) throws ServletException {
    }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			//以上為進入servlet之前
			chain.doFilter(request, response);
			//以下為走出servlet之後
			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		} catch (HibernateException e) {
			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
			e.printStackTrace();
		}
	}


	public void destroy() {
	}
}
