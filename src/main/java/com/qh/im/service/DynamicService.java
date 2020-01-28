package com.qh.im.service;

import com.qh.im.domain.DynamicDO;

import java.util.List;
import java.util.Map;

/**
 * 动态
 * 
 * @author sfsfsfs
 * @email 24242423423@qq.com
 * @date 2019-07-23 22:39:51
 */
public interface DynamicService {
	
	DynamicDO get(Long id);
	
	List<DynamicDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DynamicDO dynamic);
	
	int update(DynamicDO dynamic);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
