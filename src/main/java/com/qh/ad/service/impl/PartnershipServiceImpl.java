package com.qh.ad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.qh.ad.dao.PartnershipDao;
import com.qh.ad.domain.PartnershipDO;
import com.qh.ad.service.PartnershipService;
import com.qh.redis.service.RedisUtil;



@Service
public class PartnershipServiceImpl implements PartnershipService {
	@Autowired
	private PartnershipDao partnershipDao;
	
	@Override
	public PartnershipDO get(Long id){
		return partnershipDao.get(id);
	}
	
	@Override
	public List<PartnershipDO> list(Map<String, Object> map){
		return partnershipDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return partnershipDao.count(map);
	}
	
	@Override
	public int save(PartnershipDO partnership){
		int i= partnershipDao.save(partnership);
		RedisUtil.syncPartnership(partnership, false);//同步数据
		return i;
	}
	
	@Override
	public int update(PartnershipDO partnership){
		int i= partnershipDao.update(partnership);
	//	RedisUtil.syncPartnership(partnership, true);//同步数据
		RedisUtil.syncPartnership(partnership, false);//同步数据
		return i;
	}
	
	@Override
	public int remove(Long id){
		int i= partnershipDao.remove(id);
		PartnershipDO partnership=new PartnershipDO();
		partnership.setId(id);
		RedisUtil.syncPartnership(partnership, true);//同步数据
		return i;
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return partnershipDao.batchRemove(ids);
	}

	@Override
	public void changeStatus(Long id, Integer status) {
		// TODO Auto-generated method stub
		PartnershipDO partnershipDO=partnershipDao.get(id);
		partnershipDO.setStatus(status);
		partnershipDao.update(partnershipDO);
	//	RedisUtil.syncPartnership(partnershipDO, true);//同步数据
		RedisUtil.syncPartnership(partnershipDO, false);//同步数据
	}
	
	
	
	
	
}
