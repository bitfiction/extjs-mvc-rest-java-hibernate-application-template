package com.bitfiction.mvctemplate.rest.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import com.bitfiction.mvctemplate.ejb.OneToOneEntityService;
import com.bitfiction.mvctemplate.model.OneToOneEntity;
import com.bitfiction.mvctemplate.model.User;
import com.bitfiction.mvctemplate.rest.OneToOneEntityRESTService;


/**
 * JAX-RS Example
 * 
 * This class produces a RESTful service to read the contents of the OneToOneEntity table.
 */
public class OneToOneEntityRESTServiceImpl implements OneToOneEntityRESTService {
	
	@EJB
	private OneToOneEntityService oneToOneEntityService;
	
	@Context 
	private HttpServletRequest httpRequest;
	
   public List<OneToOneEntity> view() throws Exception {
	   User user = (User) httpRequest.getSession().getAttribute("passuser");
	   return oneToOneEntityService.view(user.getBaseEntity());
   }

   public List<OneToOneEntity> update(List<OneToOneEntity> oneToOneEntities) throws Exception {
	   User user = (User) httpRequest.getSession().getAttribute("passuser");
	   return oneToOneEntityService.update(user.getBaseEntity(), oneToOneEntities);
   }

}
