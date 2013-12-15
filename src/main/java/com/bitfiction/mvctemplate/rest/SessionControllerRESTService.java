package com.bitfiction.mvctemplate.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface SessionControllerRESTService {

   @GET
   @Path("/loggedin")
   public Response isLoggedIn() throws Exception;
   
   @GET
   @Path("/properties")
   public Response getUserProperties() throws Exception;
   
   @GET
   @Path("/keepalive")
   public Response keepAlive() throws Exception;
   
}
