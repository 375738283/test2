package com.qh.ad.config;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;

import com.qh.ad.dao.AdvertisementDao;
import com.qh.ad.dao.MarketDao;
import com.qh.ad.dao.PartnershipDao;
import com.qh.ad.dao.ProductAdvertisementDao;
import com.qh.ad.dao.ProductDao;
import com.qh.ad.domain.AdvertisementDO;
import com.qh.ad.domain.MarketDO;
import com.qh.ad.domain.PartnershipDO;
import com.qh.ad.domain.ProductAdvertisementDO;
import com.qh.ad.domain.ProductDO;
import com.qh.common.dao.DictDao;
import com.qh.common.domain.DictDO;
import com.qh.redis.service.RedisUtil;
import com.qh.system.dao.ConfigDao;
import com.qh.system.domain.ConfigDO;
/**
 * 广告相关数据加载
 * @author my
 *
 */
@Configuration
@Order(2)
public class AdConfig {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(AdConfig.class);
	
	@Autowired
	private PartnershipDao partnershipDao;
	
	@Autowired
	private MarketDao marketDao;
	
	@Autowired
	private AdvertisementDao advertisementDao;
	
	
	@Autowired
	private ProductDao productDao;
	

	@Autowired
	private ProductAdvertisementDao productAdvertisementDao;
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	@PostConstruct
	public void init(){
		logger.info("=======广告相关数据加载========");
		/**合作企业***/
		List<PartnershipDO> partnerships = partnershipDao.list(null);
		for (PartnershipDO partnershipDO : partnerships) {
			RedisUtil.syncPartnership(partnershipDO,false);
		}
		/****应用市场**/
		List<MarketDO> marketList =marketDao.list(null);
		for (MarketDO marketDO : marketList) {
			RedisUtil.syncMarket(marketDO, false);
		}
		/**广告信息***/
		List<AdvertisementDO> advertisementList =advertisementDao.list(null);
		for (AdvertisementDO advertisementDO : advertisementList) {
			RedisUtil.syncAdvertisement(advertisementDO, false);
		}
		/**产品信息***/
		List<ProductDO> productList=	productDao.list(null);
		for (ProductDO productDO : productList) {
			RedisUtil.syncProduct(productDO, false);
		}
		
		/***产品广告信息****/
	    List<ProductAdvertisementDO> productAdvertisementList=	productAdvertisementDao.list(null);
	    for (ProductAdvertisementDO productAdvertisementDO : productAdvertisementList) {
	    	RedisUtil.syncProductAdvertisement(productAdvertisementDO, false);
		}
	
	}

}
