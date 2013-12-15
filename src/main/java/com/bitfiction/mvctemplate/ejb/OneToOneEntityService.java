package com.bitfiction.mvctemplate.ejb;

import java.util.List;

import javax.ejb.Local;

import com.bitfiction.mvctemplate.model.BaseEntity;
import com.bitfiction.mvctemplate.model.OneToOneEntity;

@Local
public interface OneToOneEntityService {

	public List<OneToOneEntity> view(BaseEntity baseEntity);
	
	public List<OneToOneEntity> update(BaseEntity baseEntity, List<OneToOneEntity> oneToOneEntities);
	
}
