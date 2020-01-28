package com.qh.ad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.qh.ad.dao.ProductDownloadDao;
import com.qh.ad.domain.ProductDownloadDO;
import com.qh.ad.service.ProductDownloadService;



@Service
public class ProductDownloadServiceImpl implements ProductDownloadService {
	@Autowired
	private ProductDownloadDao productDownloadDao;
	
	@Override
	public ProductDownloadDO get(Long id){
		return productDownloadDao.get(id);
	}
	
	@Override
	public List<ProductDownloadDO> list(Map<String, Object> map){
		return productDownloadDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return productDownloadDao.count(map);
	}
	
	@Override
	public int save(ProductDownloadDO productDownload){
		return productDownloadDao.save(productDownload);
	}
	
	@Override
	public int update(ProductDownloadDO productDownload){
		return productDownloadDao.update(productDownload);
	}
	
	@Override
	public int remove(Long id){
		return productDownloadDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return productDownloadDao.batchRemove(ids);
	}

	@Override
	public void download(Long productId, Long marketId, String ip, String phone) {
		// TODO Auto-generated method stub
		ProductDownloadDO prductDownloadDO=new ProductDownloadDO();
		prductDownloadDO.setProductId(productId);
		prductDownloadDO.setMarketId(marketId);
		prductDownloadDO.setIp(ip);
		prductDownloadDO.setPhone(phone);
		productDownloadDao.save(prductDownloadDO);
	}
	
	
	
	
}
