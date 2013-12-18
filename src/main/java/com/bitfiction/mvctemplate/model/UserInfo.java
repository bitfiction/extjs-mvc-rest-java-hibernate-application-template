package com.bitfiction.mvctemplate.model;


/**
 * Class aggregates multiple entities.
 * It is used in admin view for user data overview.  
 * 
 * @author endriju
 *
 */
public class UserInfo {
   
   public UserInfo() {
	   super();
   }
   
   public UserInfo(User user, BaseEntity baseEntity, OneToOneEntity oneToOneEntity) {
	   super();
	   this.user = user;
	   this.baseEntity = baseEntity;
	   this.oneToOneEntity = oneToOneEntity;
   }
   
   private User user;
   
   private BaseEntity baseEntity;
   
   private OneToOneEntity oneToOneEntity;
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public BaseEntity getBaseEntity() {
		return baseEntity;
	}
	
	public void setBaseEntity(BaseEntity baseEntity) {
		this.baseEntity = baseEntity;
	}
	
	public OneToOneEntity getOneToOneEntity() {
		return oneToOneEntity;
	}
	
	public void setOneToOneEntity(OneToOneEntity oneToOneEntity) {
		this.oneToOneEntity = oneToOneEntity;
	}

}
