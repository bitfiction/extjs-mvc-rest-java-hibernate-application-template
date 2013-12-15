package com.bitfiction.mvctemplate.ejb.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.jboss.ejb3.annotation.SecurityDomain;

import com.bitfiction.mvctemplate.ejb.OneToManyEntityService;
import com.bitfiction.mvctemplate.model.BaseEntity;
import com.bitfiction.mvctemplate.model.OneToManyEntity;

@Stateless
@RolesAllowed({ "user" })
@SecurityDomain("ExtjsMVCTemplateRealm")
public class OneToManyEntityServiceImpl implements OneToManyEntityService {

	@Inject
	private EntityManager em;
	
	@Inject
	private Logger log;
	
	private static final String SELECT = 
			"select entity from OneToManyEntity entity where entity.baseEntity = :baseEntity order by entity.id";
	
	public List<OneToManyEntity> view(BaseEntity baseEntity) {
		log.info("Get OneToManyEntities for baseEntity: " + baseEntity.getId());
		
		@SuppressWarnings("unchecked")
		final List<OneToManyEntity> results = em.createQuery(SELECT)
			.setParameter("baseEntity", baseEntity)
			.getResultList();
		
		log.info("OK: Get OneToManyEntities for baseEntity: " + baseEntity.getId());
		
		return results;
	}
	
	public List<OneToManyEntity> create(BaseEntity baseEntity, List<OneToManyEntity> oneToManyEntities) {
		log.info("Create OneToManyEntities for baseEntity: " + baseEntity.getId());
		
		List<OneToManyEntity> _oneToManyEntities = new ArrayList<OneToManyEntity>();
        for (OneToManyEntity oneToManyEntity: oneToManyEntities) {
        	oneToManyEntity.setBaseEntity(baseEntity);
        	OneToManyEntity _oneToManyEntity = em.merge(oneToManyEntity);
        	_oneToManyEntities.add(_oneToManyEntity);
		}
        
        log.info("OK: Create OneToManyEntities for baseEntity: " + baseEntity.getId());
        
	    return _oneToManyEntities;
	}

	public List<OneToManyEntity> update(BaseEntity baseEntity, List<OneToManyEntity> oneToManyEntities) {
		log.info("Update OneToManyEntities for baseEntity: " + baseEntity.getId());
		
		List<OneToManyEntity> _oneToManyEntities = new ArrayList<OneToManyEntity>();
        for (OneToManyEntity oneToManyEntity: oneToManyEntities) {
        	oneToManyEntity.setBaseEntity(baseEntity);
        	OneToManyEntity _oneToManyEntity = em.merge(oneToManyEntity);
        	_oneToManyEntities.add(_oneToManyEntity);
		}
        
        log.info("OK: Update OneToManyEntities for baseEntity: " + baseEntity.getId());
        
	    return _oneToManyEntities;
	}
	
	public List<OneToManyEntity> delete(BaseEntity baseEntity, List<OneToManyEntity> oneToManyEntities) {
		log.info("Delete OneToManyEntities for baseEntity: " + baseEntity.getId());
		
		for (OneToManyEntity b: oneToManyEntities) {
        	em.remove(em.merge(b));
		}
		
		log.info("OK: Delete OneToManyEntities for baseEntity: " + baseEntity.getId());
		
		return oneToManyEntities;
	}

}
