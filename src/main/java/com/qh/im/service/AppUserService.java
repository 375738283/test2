package com.qh.im.service;

import com.qh.common.utils.R;
import com.qh.im.domain.AppUserDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author sfsfsfs
 * @email 24242423423@qq.com
 * @date 2019-07-23 22:39:51
 */
public interface AppUserService {
	
	AppUserDO get(Long id);
	
	List<AppUserDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(AppUserDO appUser);
	
	int update(AppUserDO appUser);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	
	R register(String mobile,String password);
	
	R login(String mobile,String password);
	
	
}
