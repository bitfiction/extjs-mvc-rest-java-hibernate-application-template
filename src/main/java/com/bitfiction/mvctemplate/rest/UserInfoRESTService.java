package com.bitfiction.mvctemplate.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bitfiction.mvctemplate.model.UserInfo;

@Path("/userInfo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface UserInfoRESTService {

   @GET
   @Path("/view")
   public List<UserInfo> view() throws Exception;
   
}
