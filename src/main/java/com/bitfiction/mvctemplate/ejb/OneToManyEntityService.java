package com.bitfiction.mvctemplate.ejb;

import java.util.List;

import javax.ejb.Local;

import com.bitfiction.mvctemplate.model.BaseEntity;
import com.bitfiction.mvctemplate.model.OneToManyEntity;

@Local
public interface OneToManyEntityService {
	
	public List<OneToManyEntity> view(BaseEntity baseEntity);
	
	public List<OneToManyEntity> create(BaseEntity baseEntity, List<OneToManyEntity> oneToManyEntities);

	public List<OneToManyEntity> update(BaseEntity baseEntity, List<OneToManyEntity> oneToManyEntities);
	
	public List<OneToManyEntity> delete(BaseEntity baseEntity, List<OneToManyEntity> oneToManyEntities);

}
