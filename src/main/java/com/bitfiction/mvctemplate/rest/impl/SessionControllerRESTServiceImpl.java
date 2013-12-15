package com.bitfiction.mvctemplate.rest.impl;

import java.io.Serializable;
import java.security.Principal;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.bitfiction.mvctemplate.ejb.UserService;
import com.bitfiction.mvctemplate.model.Role;
import com.bitfiction.mvctemplate.model.User;
import com.bitfiction.mvctemplate.rest.SessionControllerRESTService;


/**
 * JAX-RS Example
 * 
 * This class produces a RESTful service to read the current user data.
 */
public class SessionControllerRESTServiceImpl implements SessionControllerRESTService, Serializable {
	
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;
	
	@Inject
	private Logger log;
	
	@Context 
	private HttpServletRequest httpRequest;
	
	@EJB
	private UserService userService;
	
	private final String SELECT_USER = "select u from User u where u.username = :user";
	
	public Response isLoggedIn() throws Exception {
		Principal principal = httpRequest.getUserPrincipal();
		if (principal == null) {
			log.info("check if user is logged in for null");
		} else {
			log.info("check if user is logged in for: " + principal.getName());
		}
		
		StringBuilder response = new StringBuilder();
		
		if (httpRequest.getUserPrincipal() == null || httpRequest.getUserPrincipal().getName().equalsIgnoreCase("anonymous")) {
	        response.append("{success: true, isLoggedIn: ").append(false).append("}");
	        return Response.ok().entity(response.toString()).type(MediaType.APPLICATION_JSON).build();
		} else {
			response.append("{success: true, isLoggedIn: ").append(true).append("}");
	        return Response.ok().entity(response.toString()).type(MediaType.APPLICATION_JSON).build();
		}
	}

	public Response getUserProperties() throws Exception {
		Principal principal = httpRequest.getUserPrincipal();
		if (principal == null) {
			log.info("read user properties for null");
		} else {
			log.info("read user properties for: " + principal.getName());
		}
		
		User user = null;
		
		if (principal == null || 
			principal.getName() == null || 
			principal.getName().equalsIgnoreCase("anonymous")) {
			httpRequest.getSession().setAttribute("loggedin", false);
		} else {
			@SuppressWarnings("unchecked")
			final List<User> results = em.createQuery(SELECT_USER)
				.setParameter("user", principal.getName())
				.getResultList();
			if (results != null && !results.isEmpty()) {
				user = results.get(0);
				httpRequest.getSession().setAttribute("passuser", user);
			}
			if (user != null) {
				httpRequest.getSession().setAttribute("loggedin", true);
			}
		}
		
		long userId = user == null ? -1 : user.getId();
		String username = user == null ? "''" : "'" + user.getUsername() + "'";
		
		boolean isAdminMode = false;
		
		if (user!= null && user.getRoles() != null) {
			for (Role role: user.getRoles()) {
				if (role.getRolename().equalsIgnoreCase("admin")) {
					isAdminMode = true;
					break;
				}
			}
		}
		
		if (!isAdminMode) {
			// determine read-only access depending on school read-only mode
			if (principal != null && user.getBaseEntity() != null) {
				log.info("school for user: " + principal.getName() + " has schoolid: " + user.getBaseEntity().getId());
			}	
		}
		
		StringBuilder response = new StringBuilder();
        response.append("{success: true, isAdminMode: ").append(isAdminMode).append(", ")
        		.append("username: ").append(username).append(", ").append("userId: ")
                .append(userId).append("}");
        return Response.ok().entity(response.toString()).type(MediaType.APPLICATION_JSON).build();
	}
	
	public Response keepAlive() throws Exception {
		Principal principal = httpRequest.getUserPrincipal();
		if (principal == null) {
			log.info("keeping alive: null");
		} else {
			log.info("keeping alive: " + principal.getName());
		}
		StringBuilder response = new StringBuilder();
        response.append("{success: true}");
		return Response.ok().entity(response.toString()).type(MediaType.APPLICATION_JSON).build();
	}
}
