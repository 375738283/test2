package com.qh.im.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.qh.im.dao.PhotoAlbumDao;
import com.qh.im.domain.PhotoAlbumDO;
import com.qh.im.service.PhotoAlbumService;



@Service
public class PhotoAlbumServiceImpl implements PhotoAlbumService {
	@Autowired
	private PhotoAlbumDao photoAlbumDao;
	
	@Override
	public PhotoAlbumDO get(Long id){
		return photoAlbumDao.get(id);
	}
	
	@Override
	public List<PhotoAlbumDO> list(Map<String, Object> map){
		return photoAlbumDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return photoAlbumDao.count(map);
	}
	
	@Override
	public int save(PhotoAlbumDO photoAlbum){
		return photoAlbumDao.save(photoAlbum);
	}
	
	@Override
	public int update(PhotoAlbumDO photoAlbum){
		return photoAlbumDao.update(photoAlbum);
	}
	
	@Override
	public int remove(Long id){
		return photoAlbumDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return photoAlbumDao.batchRemove(ids);
	}
	
}
