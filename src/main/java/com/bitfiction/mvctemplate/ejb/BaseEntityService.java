package com.bitfiction.mvctemplate.ejb;

import java.util.List;

import javax.ejb.Local;

import com.bitfiction.mvctemplate.model.BaseEntity;

@Local
public interface BaseEntityService {
	
	public BaseEntity findById(String id);
	
	public List<BaseEntity> view();
	
	public List<BaseEntity> update(List<BaseEntity> baseEntities);

}
