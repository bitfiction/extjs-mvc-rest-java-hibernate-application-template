package com.bitfiction.mvctemplate.ejb.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.jboss.ejb3.annotation.SecurityDomain;

import com.bitfiction.mvctemplate.ejb.BaseEntityService;
import com.bitfiction.mvctemplate.model.BaseEntity;

@Stateless
@RolesAllowed({ "user" })
@SecurityDomain("ExtjsMVCTemplateRealm")
public class BaseEntityServiceImpl implements BaseEntityService {

	@Inject
	private EntityManager em;
	
	@Inject
	private Logger log;
	
	private static final String SELECT_BY_ID = "select entity from BaseEntity entity where entity.id = :id";
	
	private static final String SELECT = "select entity from BaseEntity entity";
	
	public BaseEntity findById(String id) {
		@SuppressWarnings("unchecked")
		final List<BaseEntity> results = em.createQuery(SELECT_BY_ID)
			.setParameter("id", Long.valueOf(id))
			.getResultList();
		
		if (results != null && !results.isEmpty()) {
			return results.get(0);
		}
		return null;
	}
	
	public List<BaseEntity> view() {
		log.info("Get BaseEntities");
		
		@SuppressWarnings("unchecked")
		final List<BaseEntity> results = em.createQuery(SELECT).getResultList();
		
		log.info("OK: Get BaseEntities");
		
		return results;
	}
	
	public List<BaseEntity> update(List<BaseEntity> baseEntities) {
		log.info("Update BaseEntities");
		
		List<BaseEntity> _baseEntities = new ArrayList<BaseEntity>();
        for (BaseEntity baseEntity: baseEntities) {
        	BaseEntity _baseEntity = em.merge(baseEntity);
        	_baseEntities.add(_baseEntity);
		}
        
        log.info("OK: Update BaseEntities");
        
	    return _baseEntities;
	}

}
