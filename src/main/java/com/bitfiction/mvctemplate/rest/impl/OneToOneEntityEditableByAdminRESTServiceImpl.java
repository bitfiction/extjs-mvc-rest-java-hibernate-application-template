package com.bitfiction.mvctemplate.rest.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import com.bitfiction.mvctemplate.ejb.OneToOneEntityEditableByAdminService;
import com.bitfiction.mvctemplate.model.OneToOneEntityEditableByAdmin;
import com.bitfiction.mvctemplate.model.User;
import com.bitfiction.mvctemplate.rest.OneToOneEntityEditableByAdminRESTService;


/**
 * JAX-RS Example
 * 
 * This class produces a RESTful service to read the contents of the OneToOneEntityEditableByAdmin table.
 */
public class OneToOneEntityEditableByAdminRESTServiceImpl implements OneToOneEntityEditableByAdminRESTService {
	
	@EJB
	private OneToOneEntityEditableByAdminService oneToOneEntityEditableByAdminService;
	
	@Context 
	private HttpServletRequest httpRequest;
	
	public List<OneToOneEntityEditableByAdmin> view() throws Exception {
		User user = (User) httpRequest.getSession().getAttribute("passuser");
		return oneToOneEntityEditableByAdminService.view(user.getBaseEntity());
	}

	public List<OneToOneEntityEditableByAdmin> update(List<OneToOneEntityEditableByAdmin> oneToOneEntityEditableByAdmin) throws Exception {
		return oneToOneEntityEditableByAdminService.update(oneToOneEntityEditableByAdmin);
	}

}
