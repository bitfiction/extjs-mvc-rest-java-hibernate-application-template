package com.bitfiction.mvctemplate.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bitfiction.mvctemplate.model.OneToOneEntity;

@Path("/oneToOneEntity")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface OneToOneEntityRESTService {

   @GET
   @Path("/view")
   public List<OneToOneEntity> view() throws Exception;
   
   @POST
   @Path("/update")
   public List<OneToOneEntity> update(List<OneToOneEntity> oneToOneEntities) throws Exception;
   
}
