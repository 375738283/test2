package com.qh.ad.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 产品下载信息表
 * 
 * @author bawan
 * @email 24242423423@qq.com
 * @date 2019-07-12 22:13:11
 */
public class ProductDownloadDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//ID
	private Long id;
	//产品id
	private Long productId;
	//市场id
	private Long marketId;
	//IP
	private String ip;
	//手机号
	private String phone;
	//创建时间
	private Date createTime;
	//设备名字
	private String deviceName;

	/**
	 * 设置：ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：ID
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：产品id
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	/**
	 * 获取：产品id
	 */
	public Long getProductId() {
		return productId;
	}
	/**
	 * 设置：市场id
	 */
	public void setMarketId(Long marketId) {
		this.marketId = marketId;
	}
	/**
	 * 获取：市场id
	 */
	public Long getMarketId() {
		return marketId;
	}
	/**
	 * 设置：IP
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	/**
	 * 获取：IP
	 */
	public String getIp() {
		return ip;
	}
	/**
	 * 设置：手机号
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：手机号
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	
	
	
	
}
