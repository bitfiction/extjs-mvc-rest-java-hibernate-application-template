package com.bitfiction.mvctemplate.util;

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.bitfiction.mvctemplate.model.User;

@Provider
public class DefaultExceptionHandler implements ExceptionMapper<Exception> {

	@Inject
	private Logger log;
	
	@Context 
	private HttpServletRequest httpRequest;
	
    @Override
    public Response toResponse(Exception e) {
    	String username = "unknown";
    	if (httpRequest != null && httpRequest.getSession() != null && httpRequest.getSession().getAttribute("passuser") != null) {
    		username = ((User) httpRequest.getSession().getAttribute("passuser")).getUsername();
    	}
    	log.severe("Handling exception: " + e.getMessage() + " for user: " + username);
        StringBuilder response = new StringBuilder();
        response.append("{success: false, msg: '").append(e.getMessage()).append("'}");
        return Response.serverError().entity(response.toString()).type(MediaType.APPLICATION_JSON).build();
    }
    
}