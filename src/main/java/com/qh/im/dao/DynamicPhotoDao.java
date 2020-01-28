package com.qh.im.dao;

import com.qh.im.domain.DynamicPhotoDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 动态相册关联表
 * @author sfsfsfs
 * @email 24242423423@qq.com
 * @date 2019-07-23 22:39:52
 */
@Mapper
public interface DynamicPhotoDao {

	DynamicPhotoDO get(Long id);
	
	List<DynamicPhotoDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(DynamicPhotoDO dynamicPhoto);
	
	int update(DynamicPhotoDO dynamicPhoto);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
