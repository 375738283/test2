package com.qh.ad.service;

import com.qh.ad.domain.MarketDO;

import java.util.List;
import java.util.Map;

/**
 * 应该市场
 * 
 * @author bawan
 * @email 24242423423@qq.com
 * @date 2019-07-12 22:13:10
 */
public interface MarketService {
	
	MarketDO get(Long id);
	
	List<MarketDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(MarketDO market);
	
	int update(MarketDO market);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
