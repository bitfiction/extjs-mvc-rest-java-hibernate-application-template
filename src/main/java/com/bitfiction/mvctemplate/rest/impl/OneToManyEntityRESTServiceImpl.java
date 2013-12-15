package com.bitfiction.mvctemplate.rest.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import com.bitfiction.mvctemplate.ejb.OneToManyEntityService;
import com.bitfiction.mvctemplate.model.OneToManyEntity;
import com.bitfiction.mvctemplate.model.User;
import com.bitfiction.mvctemplate.rest.OneToManyEntityRESTService;


/**
 * JAX-RS Example
 * 
 * This class produces a RESTful service to read the contents of the OneToManyEntity table.
 */
public class OneToManyEntityRESTServiceImpl implements OneToManyEntityRESTService {
	
	@EJB
	private OneToManyEntityService oneToManyEntityService;
	
	@Context 
	private HttpServletRequest httpRequest;

   public List<OneToManyEntity> view() throws Exception {
	   User user = (User) httpRequest.getSession().getAttribute("passuser");
	   return oneToManyEntityService.view(user.getBaseEntity());
   }
   
   public List<OneToManyEntity> create(List<OneToManyEntity> buildings) throws Exception {
	   User user = (User) httpRequest.getSession().getAttribute("passuser");
	   return oneToManyEntityService.create(user.getBaseEntity(), buildings);
   }

   public List<OneToManyEntity> update(List<OneToManyEntity> buildings) throws Exception {
	   User user = (User) httpRequest.getSession().getAttribute("passuser");
	   return oneToManyEntityService.update(user.getBaseEntity(), buildings);
   }
	
   public List<OneToManyEntity> delete(List<OneToManyEntity> buildings) throws Exception {
	   User user = (User) httpRequest.getSession().getAttribute("passuser");
	   return oneToManyEntityService.delete(user.getBaseEntity(), buildings);
   }
   
}
