package com.qh.im.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.qh.im.dao.DynamicPhotoDao;
import com.qh.im.domain.DynamicPhotoDO;
import com.qh.im.service.DynamicPhotoService;



@Service
public class DynamicPhotoServiceImpl implements DynamicPhotoService {
	@Autowired
	private DynamicPhotoDao dynamicPhotoDao;
	
	@Override
	public DynamicPhotoDO get(Long id){
		return dynamicPhotoDao.get(id);
	}
	
	@Override
	public List<DynamicPhotoDO> list(Map<String, Object> map){
		return dynamicPhotoDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return dynamicPhotoDao.count(map);
	}
	
	@Override
	public int save(DynamicPhotoDO dynamicPhoto){
		return dynamicPhotoDao.save(dynamicPhoto);
	}
	
	@Override
	public int update(DynamicPhotoDO dynamicPhoto){
		return dynamicPhotoDao.update(dynamicPhoto);
	}
	
	@Override
	public int remove(Long id){
		return dynamicPhotoDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return dynamicPhotoDao.batchRemove(ids);
	}
	
}
