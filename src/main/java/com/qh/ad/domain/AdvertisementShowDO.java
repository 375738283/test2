package com.qh.ad.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 广告展示表
 * 
 * @author bawan
 * @email 24242423423@qq.com
 * @date 2019-07-12 22:13:10
 */
public class AdvertisementShowDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//ID
	private Long id;
	//广告id
	private Long advertisementId;
	//app产品id
	private Long productId;
	//IP
	private String ip;
	//手机号
	private String phone;
	//设备名字
	private String deviceName;
	//创建时间
	private Date createTime;

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
	 * 设置：广告id
	 */
	public void setAdvertisementId(Long advertisementId) {
		this.advertisementId = advertisementId;
	}
	/**
	 * 获取：广告id
	 */
	public Long getAdvertisementId() {
		return advertisementId;
	}
	/**
	 * 设置：app产品id
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	/**
	 * 获取：app产品id
	 */
	public Long getProductId() {
		return productId;
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
