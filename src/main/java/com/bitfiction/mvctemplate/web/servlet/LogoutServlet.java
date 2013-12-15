package com.bitfiction.mvctemplate.web.servlet;

import java.io.IOException;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitfiction.mvctemplate.model.User;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Logger log;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = "unknown";
		if (request.getSession() != null && request.getSession().getAttribute("passuser") != null) {
			username = ((User) request.getSession().getAttribute("passuser")).getUsername();
    	}
		
		log.info("Logging out user: " + username);
		response.setHeader("Cache-Control", "no-cache, no-store");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", new java.util.Date().toString()); //http://www.coderanch.com/t/541412/Servlets/java/Logout-servlet-button 
        
        if(request.getSession(false)!=null){
            request.getSession(false).invalidate();
        }
        if(request.getSession()!=null){
            request.getSession().invalidate();
        }
        
    	try {
    		request.logout();
		} catch (ServletException e) {
			log.severe("ERR: Logout user: " + username);
		}
    	response.sendRedirect(request.getContextPath());
    	log.info("OK: Logout user: " + username);
	}
	
}

