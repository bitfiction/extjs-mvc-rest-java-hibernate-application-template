package com.bitfiction.mvctemplate.ejb;

import java.util.List;

import javax.ejb.Local;

import com.bitfiction.mvctemplate.model.BaseEntity;
import com.bitfiction.mvctemplate.model.OneToOneEntityEditableByAdmin;

@Local
public interface OneToOneEntityEditableByAdminService {

	public List<OneToOneEntityEditableByAdmin> view(BaseEntity baseEntity);
	
	public List<OneToOneEntityEditableByAdmin> update(List<OneToOneEntityEditableByAdmin> oneToOneEntitiesEditableAdmin);
	
	public OneToOneEntityEditableByAdmin createOneToOneEntityEditableByAdminForBaseEntity(BaseEntity baseEntity);
	
}
