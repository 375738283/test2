package com.qh.ad.service;

import com.qh.ad.domain.ProductDO;

import java.util.List;
import java.util.Map;

/**
 * app产品
 * 
 * @author bawan
 * @email 24242423423@qq.com
 * @date 2019-07-12 22:13:11
 */
public interface ProductService {
	
	ProductDO get(Long id);
	
	List<ProductDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ProductDO product);
	
	int update(ProductDO product);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	
	
	/**
	 * 改变推送状态
	 * @param id
	 * @param status
	 */
	void changePushSwitch(Long id,Integer pushSwitch);
}
