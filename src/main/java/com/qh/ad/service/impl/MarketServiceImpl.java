package com.qh.ad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.qh.ad.dao.MarketDao;
import com.qh.ad.domain.MarketDO;
import com.qh.ad.service.MarketService;
import com.qh.redis.service.RedisUtil;



@Service
public class MarketServiceImpl implements MarketService {
	@Autowired
	private MarketDao marketDao;
	
	@Override
	public MarketDO get(Long id){
		return marketDao.get(id);
	}
	
	@Override
	public List<MarketDO> list(Map<String, Object> map){
		return marketDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return marketDao.count(map);
	}
	
	@Override
	public int save(MarketDO market){
		int i= marketDao.save(market);
		RedisUtil.syncMarket(market, false);//同步数据
		return i;
	}
	
	@Override
	public int update(MarketDO market){
		int i= marketDao.update(market);
	//	RedisUtil.syncMarket(market, true);//同步数据
		RedisUtil.syncMarket(market, false);//同步数据
		return i;
	}
	
	@Override
	public int remove(Long id){
		int i= marketDao.remove(id);
		MarketDO market=new MarketDO();
		market.setId(id);
		RedisUtil.syncMarket(market, true);//同步数据
		return i;
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return marketDao.batchRemove(ids);
	}
	
}
