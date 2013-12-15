package com.bitfiction.mvctemplate.ejb;

import javax.ejb.Local;

import com.bitfiction.mvctemplate.model.BaseEntity;
import com.bitfiction.mvctemplate.model.User;

@Local
public interface UserService {

	public User findByBaseEntity(BaseEntity baseEntity);

}
