package com.qh.ad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.qh.ad.dao.ProductAdvertisementDao;
import com.qh.ad.dao.ProductDao;
import com.qh.ad.domain.ProductAdvertisementDO;
import com.qh.ad.domain.ProductDO;
import com.qh.ad.service.ProductService;
import com.qh.redis.service.RedisUtil;



@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ProductAdvertisementDao productAdvertisementDao;
	
	@Override
	public ProductDO get(Long id){
		return productDao.get(id);
	}
	
	@Override
	public List<ProductDO> list(Map<String, Object> map){
		return productDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return productDao.count(map);
	}
	
	@Override
	public int save(ProductDO product){
		int c= productDao.save(product);
		RedisUtil.syncProduct(product, false);//同步信息
		//添加广告关联数据
		if(product.getAdvertisementIdList()!=null&&product.getAdvertisementIdList().size()>0) {
			for (int i=0;i<product.getAdvertisementIdList().size();i++) {
				Long advertisementId=product.getAdvertisementIdList().get(i);
				ProductAdvertisementDO temp=new ProductAdvertisementDO();
				temp.setProductId(product.getId());
				temp.setAdvertisementId(advertisementId);
				temp.setSeq(i);
				productAdvertisementDao.save(temp);
				RedisUtil.syncProductAdvertisement(temp, false);//同步信息
			}
		}
		return c;
	}
	
	@Override
	public int update(ProductDO product){
		int c= productDao.update(product);
		RedisUtil.syncProduct(product, false);//同步信息
		
		
		
		//修改广告关联数据
		productAdvertisementDao.removeByProductId(product.getId());
		RedisUtil.delProductAdvertisementByProductId(product.getId());
		
		if(product.getAdvertisementIdList()!=null&&product.getAdvertisementIdList().size()>0) {
			for (int i=0;i<product.getAdvertisementIdList().size();i++) {
				Long advertisementId=product.getAdvertisementIdList().get(i);
				ProductAdvertisementDO temp=new ProductAdvertisementDO();
				temp.setProductId(product.getId());
				temp.setAdvertisementId(advertisementId);
				temp.setSeq(i);
				productAdvertisementDao.save(temp);
				RedisUtil.syncProductAdvertisement(temp, false);//同步信息
			}
		}
		return c;
	}
	
	@Override
	public int remove(Long id){
		int i= productDao.remove(id);
		ProductDO productDO=new ProductDO();
		productDO.setId(id);
		RedisUtil.syncProduct(productDO, true);//同步信息
		
		//删除产品广告关联数据
		productAdvertisementDao.removeByProductId(id);
		RedisUtil.delProductAdvertisementByProductId(id);
		return i;
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return productDao.batchRemove(ids);
	}

	@Override
	public void changePushSwitch(Long id, Integer pushSwitch) {
		// TODO Auto-generated method stub
		ProductDO productDO=productDao.get(id);
		productDO.setPushSwitch(pushSwitch);
		productDao.update(productDO);
		RedisUtil.syncProduct(productDO, false);//同步信息
		
	}
	
	
	
	
	
}
