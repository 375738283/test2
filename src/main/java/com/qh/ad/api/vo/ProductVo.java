package com.qh.ad.api.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductVo implements Serializable {
	
	private Long id;
	
	private String name;
	
	//推送开关：0禁用,1启用
	private int pushSwitch;
	
	List<AdvertisementVo> list=new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPushSwitch() {
		return pushSwitch;
	}

	public void setPushSwitch(int pushSwitch) {
		this.pushSwitch = pushSwitch;
	}

	public List<AdvertisementVo> getList() {
		return list;
	}

	public void setList(List<AdvertisementVo> list) {
		this.list = list;
	}
	
	

}
