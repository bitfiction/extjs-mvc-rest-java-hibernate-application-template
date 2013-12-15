package com.bitfiction.mvctemplate.ejb.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.jboss.ejb3.annotation.SecurityDomain;

import com.bitfiction.mvctemplate.ejb.OneToOneEntityService;
import com.bitfiction.mvctemplate.model.BaseEntity;
import com.bitfiction.mvctemplate.model.OneToOneEntity;

@Stateless
@RolesAllowed({ "user" })
@SecurityDomain("ExtjsMVCTemplateRealm")
public class OneToOneEntityServiceImpl implements OneToOneEntityService {

	@Inject
	private EntityManager em;
	
	@Inject
	private Logger log;
	
	public List<OneToOneEntity> view(BaseEntity baseEntity) {
		log.info("Get OneToOneEntity for baseEntity: " + baseEntity.getId());
		
		List<OneToOneEntity> results = new ArrayList<OneToOneEntity>();
		results.add(baseEntity.getOneToOneEntity());
		
		log.info("OK: Get OneToOneEntity for baseEntity: " + baseEntity.getId());
		
		return results;
	}

	public List<OneToOneEntity> update(BaseEntity baseEntity, List<OneToOneEntity> oneToOneEntities) {
		log.info("Update OneToOneEntity for baseEntity: " + baseEntity.getId());
		
		List<OneToOneEntity> _oneToOneEntities = new ArrayList<OneToOneEntity>();
        for (OneToOneEntity oneToOneEntity: oneToOneEntities) {
        	oneToOneEntity = em.merge(oneToOneEntity);
        	baseEntity.setOneToOneEntity(oneToOneEntity);
		}
        
        log.info("OK: Update OneToOneEntity for baseEntity: " + baseEntity.getId());
        
	    return _oneToOneEntities;
	}

}
