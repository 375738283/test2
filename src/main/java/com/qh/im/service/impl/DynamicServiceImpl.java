package com.qh.im.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.qh.im.dao.DynamicDao;
import com.qh.im.domain.DynamicDO;
import com.qh.im.service.DynamicService;



@Service
public class DynamicServiceImpl implements DynamicService {
	@Autowired
	private DynamicDao dynamicDao;
	
	@Override
	public DynamicDO get(Long id){
		return dynamicDao.get(id);
	}
	
	@Override
	public List<DynamicDO> list(Map<String, Object> map){
		return dynamicDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return dynamicDao.count(map);
	}
	
	@Override
	public int save(DynamicDO dynamic){
		return dynamicDao.save(dynamic);
	}
	
	@Override
	public int update(DynamicDO dynamic){
		return dynamicDao.update(dynamic);
	}
	
	@Override
	public int remove(Long id){
		return dynamicDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return dynamicDao.batchRemove(ids);
	}
	
}
