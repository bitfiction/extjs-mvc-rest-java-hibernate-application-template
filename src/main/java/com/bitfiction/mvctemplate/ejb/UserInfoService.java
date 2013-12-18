package com.bitfiction.mvctemplate.ejb;

import java.util.List;

import javax.ejb.Local;

import com.bitfiction.mvctemplate.model.UserInfo;

@Local
public interface UserInfoService {

	public List<UserInfo> view();

}
