package com.qh.ad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.qh.ad.dao.ProductAdvertisementDao;
import com.qh.ad.domain.ProductAdvertisementDO;
import com.qh.ad.service.ProductAdvertisementService;



@Service
public class ProductAdvertisementServiceImpl implements ProductAdvertisementService {
	@Autowired
	private ProductAdvertisementDao productAdvertisementDao;
	
	@Override
	public ProductAdvertisementDO get(Long id){
		return productAdvertisementDao.get(id);
	}
	
	@Override
	public List<ProductAdvertisementDO> list(Map<String, Object> map){
		return productAdvertisementDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return productAdvertisementDao.count(map);
	}
	
	@Override
	public int save(ProductAdvertisementDO productAdvertisement){
		return productAdvertisementDao.save(productAdvertisement);
	}
	
	@Override
	public int update(ProductAdvertisementDO productAdvertisement){
		return productAdvertisementDao.update(productAdvertisement);
	}
	
	@Override
	public int remove(Long id){
		return productAdvertisementDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return productAdvertisementDao.batchRemove(ids);
	}
	
}
