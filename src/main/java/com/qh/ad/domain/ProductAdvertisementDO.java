package com.qh.ad.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * app产品关联广告关系表
 * 
 * @author bawan
 * @email 24242423423@qq.com
 * @date 2019-07-15 22:43:12
 */
public class ProductAdvertisementDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//ID
	private Long id;
	//app产品id
	private Long productId;
	//广告id
	private Long advertisementId;
	//排序字段
	private Integer seq;

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
	 * 设置：排序字段
	 */
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	/**
	 * 获取：排序字段
	 */
	public Integer getSeq() {
		return seq;
	}
}
