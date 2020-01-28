package com.qh.im.dao;

import com.qh.im.domain.PhotoAlbumDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 相册表
 * @author sfsfsfs
 * @email 24242423423@qq.com
 * @date 2019-07-23 22:39:52
 */
@Mapper
public interface PhotoAlbumDao {

	PhotoAlbumDO get(Long id);
	
	List<PhotoAlbumDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(PhotoAlbumDO photoAlbum);
	
	int update(PhotoAlbumDO photoAlbum);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
