package com.qh.ad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.qh.ad.dao.AdvertisementShowDao;
import com.qh.ad.domain.AdvertisementShowDO;
import com.qh.ad.service.AdvertisementShowService;



@Service
public class AdvertisementShowServiceImpl implements AdvertisementShowService {
	@Autowired
	private AdvertisementShowDao advertisementShowDao;
	
	@Override
	public AdvertisementShowDO get(Long id){
		return advertisementShowDao.get(id);
	}
	
	@Override
	public List<AdvertisementShowDO> list(Map<String, Object> map){
		return advertisementShowDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return advertisementShowDao.count(map);
	}
	
	@Override
	public int save(AdvertisementShowDO advertisementShow){
		return advertisementShowDao.save(advertisementShow);
	}
	
	@Override
	public int update(AdvertisementShowDO advertisementShow){
		return advertisementShowDao.update(advertisementShow);
	}
	
	@Override
	public int remove(Long id){
		return advertisementShowDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return advertisementShowDao.batchRemove(ids);
	}
	
}
