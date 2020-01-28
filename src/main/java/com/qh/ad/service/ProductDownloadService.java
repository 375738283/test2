package com.qh.ad.service;

import com.qh.ad.domain.ProductDownloadDO;

import java.util.List;
import java.util.Map;

/**
 * 产品下载信息表
 * 
 * @author bawan
 * @email 24242423423@qq.com
 * @date 2019-07-12 22:13:11
 */
public interface ProductDownloadService {
	
	ProductDownloadDO get(Long id);
	
	List<ProductDownloadDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ProductDownloadDO productDownload);
	
	int update(ProductDownloadDO productDownload);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	
	
	void download(Long productId,Long marketId,String ip,String phone);
}
