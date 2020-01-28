package com.qh.im.constenum;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName UserRole
 * @Description 用户角色
 * @Date 2017年11月3日 上午11:09:55
 * @version 1.0.0
 */
public enum MessageType {
	register(1);//注册
	

	private int id;
	
	private MessageType(int id){
		this.id = id;
	}
	/**
	 * @return
	 */
	public int id() {
		return this.id;
	}
}
