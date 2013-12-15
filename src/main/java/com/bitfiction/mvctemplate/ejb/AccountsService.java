package com.bitfiction.mvctemplate.ejb;

import java.util.Set;

import javax.ejb.Local;

import com.bitfiction.mvctemplate.model.BaseEntity;

@Local
public interface AccountsService {
	
	public void generateAccount(String accountEmail, String accountPassword, Set<String> rolesToAdd);
	
	public void generateAccount(String accountEmail, String accountPassword, Set<String> rolesToAdd, BaseEntity baseEntity);
	
}
