package com.qh.ad.service;

import com.qh.ad.domain.AdvertisementShowDO;

import java.util.List;
import java.util.Map;

/**
 * 广告展示表
 * 
 * @author bawan
 * @email 24242423423@qq.com
 * @date 2019-07-12 22:13:10
 */
public interface AdvertisementShowService {
	
	AdvertisementShowDO get(Long id);
	
	List<AdvertisementShowDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(AdvertisementShowDO advertisementShow);
	
	int update(AdvertisementShowDO advertisementShow);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
