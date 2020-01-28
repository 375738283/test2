package com.qh.im.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qh.common.utils.BeanMapperUtil;
import com.qh.common.utils.R;
import com.qh.im.api.vo.UserVo;
import com.qh.im.dao.AppUserDao;
import com.qh.im.domain.AppUserDO;
import com.qh.im.service.AppUserService;
import com.qh.im.yunxing.UserUtil;
import com.qh.redis.service.RedisUtil;
import com.qh.system.domain.UserDO;



@Service
public class AppUserServiceImpl implements AppUserService {
	@Autowired
	private AppUserDao appUserDao;
	
	@Override
	public AppUserDO get(Long id){
		return appUserDao.get(id);
	}
	
	@Override
	public List<AppUserDO> list(Map<String, Object> map){
		return appUserDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return appUserDao.count(map);
	}
	
	@Override
	public int save(AppUserDO appUser){
		return appUserDao.save(appUser);
	}
	
	@Override
	public int update(AppUserDO appUser){
		return appUserDao.update(appUser);
	}
	
	@Override
	public int remove(Long id){
		return appUserDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return appUserDao.batchRemove(ids);
	}

	@Override
	public R register(String mobile, String password) {
		// TODO Auto-generated method stub
		Map<String,Object> parmterMap=new HashMap<String, Object>();
		parmterMap.put("mobile", mobile);
		List<AppUserDO> list=appUserDao.list(parmterMap);
		if(list!=null&&list.size()>0)
			return R.error("用户已注册");
		try {
			R reg=UserUtil.register(mobile);
			if(R.ifSucc(reg)) {
				AppUserDO appUserDO=new AppUserDO();
				appUserDO.setMobile(mobile);
				appUserDO.setPassword(password);
				UserVo userVo=(UserVo)reg.getData();
				appUserDO.setToken(userVo.getToken());
				appUserDao.save(appUserDO);
				RedisUtil.syncUser(appUserDO, false);
				return	 R.okData(userVo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return R.error("注册失败");
	}

	@Override
	public R login(String mobile, String password) {
		// TODO Auto-generated method stub
		Map<String,Object> parmterMap=new HashMap<String, Object>();
		parmterMap.put("mobile", mobile);
		List<AppUserDO> list=appUserDao.list(parmterMap);
		if(list==null||list.size()<=0)
			return R.error("用户不存在");
		AppUserDO appUserDo=list.get(0);
		if(!password.equals(appUserDo.getPassword())) {
			return R.error("密码错误");
		}
		try {
			R r=UserUtil.refreshToken(mobile);
			if(R.ifSucc(r)) {
				UserVo userVo=(UserVo)r.getData();
				appUserDo.setToken(userVo.getToken());
				RedisUtil.syncUser(appUserDo, false);
				appUserDao.update(appUserDo);
				appUserDo.setPassword(null);
				return R.okData(appUserDo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return R.error("登陆失败");
		
	}
	
}
