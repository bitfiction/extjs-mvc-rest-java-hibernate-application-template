package com.bitfiction.mvctemplate.ejb.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.jboss.ejb3.annotation.SecurityDomain;

import com.bitfiction.mvctemplate.ejb.UserInfoService;
import com.bitfiction.mvctemplate.model.BaseEntity;
import com.bitfiction.mvctemplate.model.OneToOneEntity;
import com.bitfiction.mvctemplate.model.User;
import com.bitfiction.mvctemplate.model.UserInfo;

@Stateless
@RolesAllowed({ "admin" })
@SecurityDomain("ExtjsMVCTemplateRealm")
public class UserInfoServiceImpl implements UserInfoService {

	@Inject
	private EntityManager em;
	
	@Inject
	private Logger log;
	
	private static final String SELECT = 
			"select user, baseEntity, oneToOneEntity FROM User user, BaseEntity baseEntity, OneToOneEntity oneToOneEntity " +
			"where user.baseEntity.id = baseEntity.id and baseEntity.oneToOneEntity.id = oneToOneEntity.id";
	
	public List<UserInfo> view() {
		log.info("Get UserInfos");
		
		@SuppressWarnings("unchecked")
		List<Object[]> resultList = em.createQuery(SELECT).getResultList();
		
		List<UserInfo> userInfos = new ArrayList<UserInfo>();
		
		for (Object[] result : resultList) {
			UserInfo userInfo = new UserInfo();
			userInfo.setUser((User) result[0]);
			userInfo.setBaseEntity((BaseEntity) result[1]);
			userInfo.setOneToOneEntity((OneToOneEntity) result[2]);
			userInfos.add(userInfo);
		}
		
		log.info("OK: Get UserInfos");
		
		return userInfos;
	}

}
