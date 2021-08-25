package net.etfbl.ip.jsf.beans;

import java.io.IOException;

import javax.faces.application.ResourceHandler;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.etfbl.ip.jsp.dto.Administrator;

@WebFilter("/*")
public class LoginFilter implements Filter
{

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		HttpSession session = request.getSession(false);
		
		Administrator user = (session!=null) ? (Administrator)session.getAttribute("user") : null;
		String loginURL = request.getContextPath() + "/login.xhtml";
		
		boolean loginRequest = request.getRequestURI().startsWith(loginURL);
		boolean resourceRequest = request.getRequestURI().startsWith(request.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER);
		
		if (user != null || loginRequest || resourceRequest) {
	        arg2.doFilter(request, response);
	    } else {
	        response.sendRedirect(loginURL);
	    }
		
	}

	

}
