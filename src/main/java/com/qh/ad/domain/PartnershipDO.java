package com.qh.ad.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 合作方
 * 
 * @author bawan
 * @email 24242423423@qq.com
 * @date 2019-07-12 22:13:10
 */
public class PartnershipDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//ID
	private Long id;
	//名称
	private String name;
	//状态：0禁用,1启用
	private Integer status;
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
