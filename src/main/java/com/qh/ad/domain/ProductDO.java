package com.qh.ad.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;




/**
 * app产品
 * 
 * @author bawan
 * @email 24242423423@qq.com
 * @date 2019-07-12 22:13:11
 */
public class ProductDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//ID
	private Long id;
	//名称
	private String name;
	//市场
	private String marketIds;
	//备注
	private String remarks;
	//创建时间
	private Date createTime;
	//推送开关：0禁用,1启用
	private int pushSwitch;
	
	
	private List<Long> marketIdList;
	
	//广告
	private List<Long> advertisementIdList;
	
	private List<ProductAdvertisementDO> ProductAdvertisementList;

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
	 * 设置：市场
	 */
	public void setMarketIds(String marketIds) {
		this.marketIds = marketIds;
	}
	/**
	 * 获取：市场
	 */
	public String getMarketIds() {
		return marketIds;
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
	public int getPushSwitch() {
		return pushSwitch;
	}
	public void setPushSwitch(int pushSwitch) {
		this.pushSwitch = pushSwitch;
	}
	public List<Long> getMarketIdList() {
		 marketIdList=new ArrayList<>();
		if(StringUtils.isNotEmpty(marketIds)) {
			String marketStr[]=marketIds.split(",");
			for (String string : marketStr) {
				try {
					marketIdList.add(Long.parseLong(string));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return marketIdList;
	}
	public void setMarketIdList(List<Long> marketIdList) {
		this.marketIdList = marketIdList;
	}
	public List<Long> getAdvertisementIdList() {
		return advertisementIdList;
	}
	public void setAdvertisementIdList(List<Long> advertisementIdList) {
		this.advertisementIdList = advertisementIdList;
	}
	public List<ProductAdvertisementDO> getProductAdvertisementList() {
		return ProductAdvertisementList;
	}
	public void setProductAdvertisementList(List<ProductAdvertisementDO> productAdvertisementList) {
		ProductAdvertisementList = productAdvertisementList;
	}
	
	
	
	
	
}
