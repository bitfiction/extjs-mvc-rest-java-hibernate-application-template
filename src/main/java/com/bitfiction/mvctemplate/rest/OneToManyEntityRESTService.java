package com.bitfiction.mvctemplate.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bitfiction.mvctemplate.model.OneToManyEntity;

@Path("/oneToManyEntity")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface OneToManyEntityRESTService {

   @GET
   @Path("/view")
   public List<OneToManyEntity> view() throws Exception;
   
   @POST
   @Path("/create")
   public List<OneToManyEntity> create(List<OneToManyEntity> oneToManyEntities) throws Exception;
   
   @POST
   @Path("/update")
   public List<OneToManyEntity> update(List<OneToManyEntity> oneToManyEntities) throws Exception;
   
   @DELETE
   @Path("/delete")
   public List<OneToManyEntity> delete(List<OneToManyEntity> oneToManyEntities) throws Exception;
   
}
