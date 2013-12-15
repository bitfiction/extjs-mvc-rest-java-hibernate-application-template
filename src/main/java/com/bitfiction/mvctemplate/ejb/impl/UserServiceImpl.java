package com.bitfiction.mvctemplate.ejb.impl;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.jboss.ejb3.annotation.SecurityDomain;

import com.bitfiction.mvctemplate.ejb.UserService;
import com.bitfiction.mvctemplate.model.BaseEntity;
import com.bitfiction.mvctemplate.model.User;

@Stateless
@RolesAllowed({ "user" })
@SecurityDomain("ExtjsMVCTemplateRealm")
public class UserServiceImpl implements UserService {

	@Inject
	private EntityManager em;
	
	@Inject
	private Logger log;
	
	private static final String SELECT_BY_BASE_ENTITY = "select u from User u where u.baseEntity = :baseEntity ";
	
	public User findByBaseEntity(BaseEntity baseEntity) {
		@SuppressWarnings("unchecked")
		final List<User> results = em.createQuery(SELECT_BY_BASE_ENTITY)
			.setParameter("baseEntity", baseEntity)
			.getResultList();
		
		if (results != null && !results.isEmpty()) {
			return results.get(0);
		}
		return null;
	}

}
