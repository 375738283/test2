package com.qh.ad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.qh.ad.dao.AdvertisementDao;
import com.qh.ad.dao.ProductAdvertisementDao;
import com.qh.ad.domain.AdvertisementDO;
import com.qh.ad.domain.ProductAdvertisementDO;
import com.qh.ad.domain.ProductDO;
import com.qh.ad.service.AdvertisementService;
import com.qh.redis.service.RedisUtil;



@Service
public class AdvertisementServiceImpl implements AdvertisementService {
	@Autowired
	private AdvertisementDao advertisementDao;
	
	@Autowired
	private ProductAdvertisementDao productAdvertisementDao;
	
	@Override
	public AdvertisementDO get(Long id){
		return advertisementDao.get(id);
	}
	
	@Override
	public List<AdvertisementDO> list(Map<String, Object> map){
		return advertisementDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return advertisementDao.count(map);
	}
	
	@Override
	public int save(AdvertisementDO advertisement){
		int i= advertisementDao.save(advertisement);
		RedisUtil.syncAdvertisement(advertisement, false);//同步数据
		return i;
	}
	
	@Override
	public int update(AdvertisementDO advertisement){
		int i= advertisementDao.update(advertisement);
		RedisUtil.syncAdvertisement(advertisement, false);//同步数据
		return i;
	}
	
	@Override
	public int remove(Long id){
		int i= advertisementDao.remove(id);
		AdvertisementDO advertisement=new AdvertisementDO();
		advertisement.setId(id);
		RedisUtil.syncAdvertisement(advertisement, true);//同步数据
		
		
		//删除产品广告关联数据
		productAdvertisementDao.removeByAdvertisementId(id);
		List<ProductDO> productList=RedisUtil.getaProductList();
		for (ProductDO productDO : productList) {
			ProductAdvertisementDO productAdvertisementDO=new ProductAdvertisementDO();
			productAdvertisementDO.setProductId(productDO.getId());
			productAdvertisementDO.setAdvertisementId(id);
			RedisUtil.syncProductAdvertisement(productAdvertisementDO, true);
		}
		
		return i;
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return advertisementDao.batchRemove(ids);
	}

	@Override
	public void changeStatus(Long id, Integer status) {
		// TODO Auto-generated method stub
		AdvertisementDO advertisementDO=advertisementDao.get(id);
		advertisementDO.setStatus(status);
		advertisementDao.update(advertisementDO);
		RedisUtil.syncAdvertisement(advertisementDO, false);//同步数据
		
	}
	
	
	
	
}
