package com.bitfiction.mvctemplate.ejb.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.jboss.ejb3.annotation.SecurityDomain;

import com.bitfiction.mvctemplate.ejb.OneToOneEntityEditableByAdminService;
import com.bitfiction.mvctemplate.model.BaseEntity;
import com.bitfiction.mvctemplate.model.OneToOneEntityEditableByAdmin;

@Stateless
@RolesAllowed({ "admin" })
@SecurityDomain("ExtjsMVCTemplateRealm")
public class OneToOneEntityEditableByAdminServiceImpl implements OneToOneEntityEditableByAdminService {

	@Inject
	private EntityManager em;
	
	@Inject
	private Logger log;
	
	public List<OneToOneEntityEditableByAdmin> view(BaseEntity baseEntity) {
		log.info("Get OneToOneEntityEditableByAdmin for baseEntity: " + baseEntity.getId());
		
		List<OneToOneEntityEditableByAdmin> results = new ArrayList<OneToOneEntityEditableByAdmin>();
		results.add(baseEntity.getOneToOneEntityEditableByAdmin());
		
		log.info("OK: Get OneToOneEntityEditableByAdmin for baseEntity: " + baseEntity.getId());
		
		return results;
	}

	public List<OneToOneEntityEditableByAdmin> update(List<OneToOneEntityEditableByAdmin> oneToOneEntitiesEditableAdmin) {
		log.info("Update OneToOneEntityEditableByAdmin");
		
		List<OneToOneEntityEditableByAdmin> _oneToOneEntitiesEditableAdmin = new ArrayList<OneToOneEntityEditableByAdmin>();
        for (OneToOneEntityEditableByAdmin OneToOneEntityEditableByAdmin: oneToOneEntitiesEditableAdmin) {
        	OneToOneEntityEditableByAdmin = em.merge(OneToOneEntityEditableByAdmin);
		}
        
        log.info("OK: Update OneToOneEntityEditableByAdmin");
        
	    return _oneToOneEntitiesEditableAdmin;
	}
	
	public OneToOneEntityEditableByAdmin createOneToOneEntityEditableByAdminForBaseEntity(BaseEntity baseEntity) {
		log.info("Create OneToOneEntityEditableByAdmin for baseEntity: " + baseEntity.getId());
		OneToOneEntityEditableByAdmin OneToOneEntityEditableByAdmin = new OneToOneEntityEditableByAdmin();
		
		// initialize values if needed
		
		OneToOneEntityEditableByAdmin _merged = em.merge(OneToOneEntityEditableByAdmin);
		log.info("OK: Create OneToOneEntityEditableByAdmin for baseEntity: " + baseEntity.getId());
    	return _merged;
	}

}
