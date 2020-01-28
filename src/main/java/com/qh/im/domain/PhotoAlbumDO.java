package com.qh.im.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 相册表
 * 
 * @author sfsfsfs
 * @email 24242423423@qq.com
 * @date 2019-07-23 22:39:52
 */
public class PhotoAlbumDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//
	private Long userId;
	//
	private String url;
	//
	private Integer seq;
	//
	private Date createTime;
	//类型：0相册图片，1：动态图片
	private Integer type;

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
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置：
	 */
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	/**
	 * 获取：
	 */
	public Integer getSeq() {
		return seq;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：类型：0相册图片，1：动态图片
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：类型：0相册图片，1：动态图片
	 */
	public Integer getType() {
		return type;
	}
}
