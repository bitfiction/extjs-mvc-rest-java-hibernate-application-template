package com.bitfiction.mvctemplate.rest.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import com.bitfiction.mvctemplate.ejb.UserInfoService;
import com.bitfiction.mvctemplate.model.UserInfo;
import com.bitfiction.mvctemplate.rest.UserInfoRESTService;


/**
 * JAX-RS Example
 * 
 * This class produces a RESTful service to read the contents of the members table.
 */
public class UserInfoRESTServiceImpl implements UserInfoRESTService {
	
	@EJB
	private UserInfoService userInfoService;
	
	@Context 
	private HttpServletRequest httpRequest;
	
	public List<UserInfo> view() throws Exception {
		return userInfoService.view();
	}
	   
}
