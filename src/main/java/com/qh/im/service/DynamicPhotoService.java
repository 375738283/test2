package com.qh.im.service;

import com.qh.im.domain.DynamicPhotoDO;

import java.util.List;
import java.util.Map;

/**
 * 动态相册关联表
 * 
 * @author sfsfsfs
 * @email 24242423423@qq.com
 * @date 2019-07-23 22:39:52
 */
public interface DynamicPhotoService {
	
	DynamicPhotoDO get(Long id);
	
	List<DynamicPhotoDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DynamicPhotoDO dynamicPhoto);
	
	int update(DynamicPhotoDO dynamicPhoto);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
