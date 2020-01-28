package com.qh.ad.dao;

import com.qh.ad.domain.PartnershipDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 合作方
 * @author bawan
 * @email 24242423423@qq.com
 * @date 2019-07-12 22:13:10
 */
@Mapper
public interface PartnershipDao {

	PartnershipDO get(Long id);
	
	List<PartnershipDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(PartnershipDO partnership);
	
	int update(PartnershipDO partnership);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
