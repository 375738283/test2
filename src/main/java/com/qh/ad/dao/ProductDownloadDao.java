package com.qh.ad.dao;

import com.qh.ad.domain.ProductDownloadDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 产品下载信息表
 * @author bawan
 * @email 24242423423@qq.com
 * @date 2019-07-12 22:13:11
 */
@Mapper
public interface ProductDownloadDao {

	ProductDownloadDO get(Long id);
	
	List<ProductDownloadDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(ProductDownloadDO productDownload);
	
	int update(ProductDownloadDO productDownload);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
