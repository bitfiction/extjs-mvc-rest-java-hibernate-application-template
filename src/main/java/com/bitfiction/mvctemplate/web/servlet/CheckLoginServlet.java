package com.bitfiction.mvctemplate.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/checklogin")
public class CheckLoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Logger log;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {		
		
		Principal principal = request.getUserPrincipal();
		
		try {
			if (principal == null) {
				log.info("check if user is logged in for null");
			} else {
				log.info("check if user is logged in for: " + principal.getName());
			}
			
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			
			if (request.getUserPrincipal() == null || request.getUserPrincipal().getName().equalsIgnoreCase("anonymous")) {
				out.print("{success: true, isLoggedIn: false}");
			} else {
				out.print("{success: true, isLoggedIn: true}");
			}
			
	        out.flush();
        
		} catch (Exception ex) {
	    	log.severe("Error check logged in for user: " + principal + " msg: " + ex.getMessage());
	    	response.setContentType("application/json");
	        PrintWriter out = response.getWriter();
	        out.print("{success: false}");
	        out.flush();
	    }
        
    	log.info("OK: Login user: " + principal);
	}
	
}

