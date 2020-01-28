package com.qh.ad.service;

import com.qh.ad.domain.AdvertisementDO;

import java.util.List;
import java.util.Map;

/**
 * 广告
 * 
 * @author bawan
 * @email 24242423423@qq.com
 * @date 2019-07-12 22:13:10
 */
public interface AdvertisementService {
	
	AdvertisementDO get(Long id);
	
	List<AdvertisementDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(AdvertisementDO advertisement);
	
	int update(AdvertisementDO advertisement);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	
	/**
	 * 改变状态
	 * @param id
	 * @param status
	 */
	void changeStatus(Long id, Integer status);
}
