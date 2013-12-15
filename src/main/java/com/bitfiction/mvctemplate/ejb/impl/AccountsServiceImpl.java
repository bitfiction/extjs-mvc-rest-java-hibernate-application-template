package com.bitfiction.mvctemplate.ejb.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.commons.codec.digest.DigestUtils;
import org.jboss.ejb3.annotation.SecurityDomain;

import com.bitfiction.mvctemplate.ejb.AccountsService;
import com.bitfiction.mvctemplate.ejb.application.ApplicationService;
import com.bitfiction.mvctemplate.model.BaseEntity;
import com.bitfiction.mvctemplate.model.Role;
import com.bitfiction.mvctemplate.model.User;

@Stateless
@RolesAllowed({ "admin" })
@SecurityDomain("ExtjsMVCTemplateRealm")
public class AccountsServiceImpl implements AccountsService {

	@Inject
	private EntityManager em;
	
	@Inject
	private Logger logger;
	
	@EJB
	ApplicationService applicationService;

    private static final String SELECT_ROLE = "select r from Role r where r.rolename = :rolename";
	
	private Role getRole(String rolename) {
		logger.info("Get Role: " + rolename);
		
		@SuppressWarnings("unchecked")
		final List<Role> results = em.createQuery(SELECT_ROLE)
			.setParameter("rolename", rolename)
			.getResultList();
		
		if (results != null && !results.isEmpty()) {
			logger.info("OK: Get Role: " + rolename);
			return results.get(0);
		}
		logger.severe("ERR: Get Role: " + rolename);
		return null;
	}
	
	@Override
	public void generateAccount(String accountEmail, String accountPassword, Set<String> rolesToAdd) {
    	this.generateAccount(accountEmail, accountPassword, rolesToAdd, null);
    }
	
    @Override
	public void generateAccount(String accountEmail, String accountPassword, Set<String> rolesToAdd, BaseEntity baseEntity) {
    	String accountPasswordHashed = String.valueOf(DigestUtils.md5Hex(accountPassword));
    	
    	Set<Role> roles = new HashSet<Role>();
    	for (String roleToAdd: rolesToAdd) {
    		Role userrole = this.getRole(roleToAdd);
    		roles.add(userrole);
    	}
    	
    	User user = new User();
    	user.setUsername(accountEmail);
    	user.setPassword(accountPasswordHashed);
    	user.setRoles(roles);
    	if (baseEntity != null) {
    		user.setBaseEntity(baseEntity);
    	}
    	em.persist(user);
    	
    }

}
