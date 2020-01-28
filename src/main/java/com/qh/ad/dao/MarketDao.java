package com.qh.ad.dao;

import com.qh.ad.domain.MarketDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 应该市场
 * @author bawan
 * @email 24242423423@qq.com
 * @date 2019-07-12 22:13:10
 */
@Mapper
public interface MarketDao {

	MarketDO get(Long id);
	
	List<MarketDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(MarketDO market);
	
	int update(MarketDO market);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
