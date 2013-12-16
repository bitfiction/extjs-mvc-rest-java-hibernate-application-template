package com.bitfiction.mvctemplate.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Logger log;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		log.info("Logging in user: " + username);
		
		try {
			if (request.getUserPrincipal() != null) {
	            request.logout();
	        }
			request.getSession();
	        request.login(username, password);
			
	        response.setContentType("application/json");
	        PrintWriter out = response.getWriter();
	        out.print("{success: true}");
	        out.flush();
        
		} catch (ServletException ex) {
	    	log.severe("Error logging in user: " + username + " msg: " + ex.getMessage());
	    	response.setContentType("application/json");
	        PrintWriter out = response.getWriter();
	        out.print("{success: false}");
	        out.flush();
	    }
        
    	log.info("OK: Login user: " + username);
	}
	
	public void login(String username, String password) {
	    FacesContext context = FacesContext.getCurrentInstance();
	    HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
	    try {
	        if (request.getUserPrincipal() != null) {
	            request.logout();
	        }
	        request.login(username, password);
	    }
	    catch (ServletException ex) {
	    	log.severe("Error logging in user: " + username + " msg: " + ex.getMessage());
	    }
	}
	
}

