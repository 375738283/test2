package com.qh.ad.dao;

import com.qh.ad.domain.ProductAdvertisementDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * app产品关联广告关系表
 * @author bawan
 * @email 24242423423@qq.com
 * @date 2019-07-15 22:43:12
 */
@Mapper
public interface ProductAdvertisementDao {

	ProductAdvertisementDO get(Long id);
	
	List<ProductAdvertisementDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(ProductAdvertisementDO productAdvertisement);
	
	int update(ProductAdvertisementDO productAdvertisement);
	
	int remove(Long id);
	
	int removeByProductId(Long productId);
	
	int removeByAdvertisementId(Long advertisementId);
	
	int batchRemove(Long[] ids);
}
