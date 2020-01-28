package com.qh.ad.service;

import com.qh.ad.domain.PartnershipDO;

import java.util.List;
import java.util.Map;

/**
 * 合作方
 * 
 * @author bawan
 * @email 24242423423@qq.com
 * @date 2019-07-12 22:13:10
 */
public interface PartnershipService {
	
	PartnershipDO get(Long id);
	
	List<PartnershipDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(PartnershipDO partnership);
	
	int update(PartnershipDO partnership);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	/**
	 * 改变状态
	 * @param id
	 * @param status
	 */
	void changeStatus(Long id,Integer status);
}
