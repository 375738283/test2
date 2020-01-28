package com.qh.ad.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 广告
 * 
 * @author bawan
 * @email 24242423423@qq.com
 * @date 2019-07-12 22:13:10
 */
public class AdvertisementDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//ID
	private Long id;
	//名称
	private String name;
	//合作方ID
	private Long partnershipId;
	//合作方name
	private String partnershipName;
	//单价
	private BigDecimal price;
	//广告类型:0：显示类型;1:下载类型;2:试玩类型;
	private Integer type;
	//状态：0禁用,1启用
	private Integer status;
	//链接地址
	private String linkUrl;
	//下载地址
	private String downloadUrl;
	//图片地址
	private String pictureUrl;
	//备注
	private String remarks;
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
	 * 设置：名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：合作方ID
	 */
	public void setPartnershipId(Long partnershipId) {
		this.partnershipId = partnershipId;
	}
	/**
	 * 获取：合作方ID
	 */
	public Long getPartnershipId() {
		return partnershipId;
	}
	/**
	 * 设置：合作方name
	 */
	public void setPartnershipName(String partnershipName) {
		this.partnershipName = partnershipName;
	}
	/**
	 * 获取：合作方name
	 */
	public String getPartnershipName() {
		return partnershipName;
	}
	/**
	 * 设置：单价
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * 获取：单价
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * 设置：广告类型:0：显示类型;1:下载类型;2:试玩类型;
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：广告类型:0：显示类型;1:下载类型;2:试玩类型;
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：状态：0禁用,1启用
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态：0禁用,1启用
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：链接地址
	 */
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	/**
	 * 获取：链接地址
	 */
	public String getLinkUrl() {
		return linkUrl;
	}
	/**
	 * 设置：下载地址
	 */
	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}
	/**
	 * 获取：下载地址
	 */
	public String getDownloadUrl() {
		return downloadUrl;
	}
	/**
	 * 设置：图片地址
	 */
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	/**
	 * 获取：图片地址
	 */
	public String getPictureUrl() {
		return pictureUrl;
	}
	/**
	 * 设置：备注
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * 获取：备注
	 */
	public String getRemarks() {
		return remarks;
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
}
