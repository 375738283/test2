package com.qh.im.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 动态相册关联表
 * 
 * @author sfsfsfs
 * @email 24242423423@qq.com
 * @date 2019-07-23 22:39:52
 */
public class DynamicPhotoDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//
	private Long photoAlbumId;
	//
	private Long dynamicId;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setPhotoAlbumId(Long photoAlbumId) {
		this.photoAlbumId = photoAlbumId;
	}
	/**
	 * 获取：
	 */
	public Long getPhotoAlbumId() {
		return photoAlbumId;
	}
	/**
	 * 设置：
	 */
	public void setDynamicId(Long dynamicId) {
		this.dynamicId = dynamicId;
	}
	/**
	 * 获取：
	 */
	public Long getDynamicId() {
		return dynamicId;
	}
}
