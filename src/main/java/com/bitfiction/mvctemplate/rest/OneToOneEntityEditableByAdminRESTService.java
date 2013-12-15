package com.bitfiction.mvctemplate.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bitfiction.mvctemplate.model.OneToOneEntityEditableByAdmin;

@Path("/oneToOneEntityEditableByAdmin")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface OneToOneEntityEditableByAdminRESTService {

   @GET
   @Path("/view")
   public List<OneToOneEntityEditableByAdmin> view() throws Exception;
   
   @POST
   @Path("/update")
   public List<OneToOneEntityEditableByAdmin> update(List<OneToOneEntityEditableByAdmin> oneToOneEntityEditableByAdmin) throws Exception;
   
}
