package com.fdmgroup.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter("/*")
public class AuthenticationFilter implements Filter {

	private List<String> excludeUrls;
	
    public AuthenticationFilter() {
    	excludeUrls = new ArrayList<String>();
    	excludeUrls.add("login.jsp");
    	excludeUrls.add("/login");    	
    }

    
	public void destroy() {
		System.out.println("Destroying Authentication.......");
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpSession session = httpReq.getSession(false);
		if (((session == null) || session.getAttribute("user") == null) && !excludeUrls.contains(httpReq.getServletPath())){
			RequestDispatcher rd = httpReq.getRequestDispatcher("/WEB-INF/views/login.jsp");
			rd.forward(request, response);
			return;
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Initializing Authentication.......");
	}

}
