package com.qh.ad.dao;

import com.qh.ad.domain.AdvertisementDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 广告
 * @author bawan
 * @email 24242423423@qq.com
 * @date 2019-07-12 22:13:10
 */
@Mapper
public interface AdvertisementDao {

	AdvertisementDO get(Long id);
	
	List<AdvertisementDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(AdvertisementDO advertisement);
	
	int update(AdvertisementDO advertisement);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
